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
/*
 * Signature: makeDirty(){...}
 * 
 * This method changes editor's state to dirty
 * 
 */
function makeDirty() {
    //if(taskN=="")handleError("task name cannot be empty");
    IDESetDirty(true);
}


/*
 * Signature: makeUnDirty(){...}
 * 
 * This method changes editor's state to undirty while making the both pages of the editor stay in sync
 * 
 */
function makeUnDirty() {
    var taskN = $('#taskName').val();
    $('#taskName').val(taskN.replace(/ /g, ''));
    generateTasks();
    IDESetDirty(false);
    IDESaveContent(new XMLSerializer().serializeToString((xmlDom)));
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
function createFile(currentTaskName, state, taskNode) { //createFile
    // Create Task WSDL
    var serviceURL = $('#' + currentTaskName + 'wrapper #taskCallbackServiceURL').val();
    var operationName = $('#' + currentTaskName + 'wrapper #taskCallbackOperationName')
        .val();
    var serviceName = $('#' + currentTaskName + 'wrapper #taskCallbackServiceName').val();
    var outputElements = $('#' + currentTaskName + 'wrapper #outputmappingTable tr');
    $.get('resources/template.wsdl', function(data) {
       try {
            if (typeof data === "string"){
               wsdlDom = marshalEditorTextContent(data);
            }else {
               wsdlDom = data; 
            }
            generateInputWSDL(wsdlDom, xmlDom, currentTaskName);
            saveWSDL(wsdlDom, currentTaskName + "Task"); 

        } catch (err) {
            handleError("WSDL Error " + err);
        }

    });
    // Create Task Callback WSDL
    $.get('resources/template.wsdl', function(data) {
        try {
            if (typeof data === "string"){
               wsdlCBDom = marshalEditorTextContent(data);
            }else {
               wsdlCBDom = data; 
            }
            generateOutputWSDL(wsdlCBDom, xmlDom, currentTaskName,serviceURL,operationName,serviceName,outputElements);
            saveWSDL(wsdlCBDom, currentTaskName + "TaskCallBack");
            // generateUI();
        } catch (err) {
            handleError("Callback WSDL Error " + err);
        }

    });
    $.get('resources/templatehtconfig.ht', function(data) {
        try {
            if (typeof data === "string"){
               htconfigDom = marshalEditorTextContent(data);
            }else {
               htconfigDom = data; 
            }
            generateHTConfig(htconfigDom, xmlDom, currentTaskName);
            saveHTConfig(htconfigDom);
            if(state != "generateText" && state != "initial"){
                generateUI();
            }
            if(state == "initial"){
                generateTasks();
            }
        } catch (err) {
            handleError("HTConfig file Error " + err);
        }
    });
}

function readCBWSDL(currentTaskName) { //createFile
    try {
        cbWsdl = ExecuteCustomFunction("getwsdl", currentTaskName);
    } catch (err) {
        handleError('Error Reading CallBack WSDL');
    }
    return marshalEditorTextContent(cbWsdl);
}

/*
 * Signature: addTask(){...}
 * 
 * This method generates creates a new task. This method add a dummy task node into the ht file and adds a new task tab and Ui elements respectively
 * 
 * 
 */
function addTask() { //createFile
    $.get('resources/template.ht', function(data) {
        try {
            if (typeof data === "string"){
               taskPartDom = marshalEditorTextContent(data);
            }else {
               taskPartDom = data; 
            }
            tasks = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","tasks")[0];
            i = parseInt($('#nooftasks').val());
            nodes = Array.prototype.slice.call(xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task"), 0);
            taskExists = false;
            nodes.forEach(function(taskNode) {
                if(taskNode.getAttribute("name") == ("newTask" + i)){
                    i++;
                }
            });
            createFile("newTask" + i,"");
            taskPartDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task")[0].setAttribute("name", "newTask" + i);
            xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","tasks")[0].appendChild(xmlDom.importNode(taskPartDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task")[0], true));
            IDESaveContent(new XMLSerializer().serializeToString((xmlDom)));
            //generateUI();
            //addEvent("tabChange","page-content-wrapper ",xmlDom);
        } catch (err) {
            handleError("Error Adding New Task \n" + err);
        }
    });
}

/*
 * Signature: addInitalTask(){...}
 * 
 * This method generates an initial task document from dummy ht file 
 * 
 */
function addInitalTask() { //createFile
    $.get('resources/template.ht', function(data) {
        try {
            xmlDom = marshalEditorTextContent(data);
            IDESaveContent(data);
            tasksList = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task");
            nodes = Array.prototype.slice.call(tasksList, 0);
            $("#page-content-wrapper #tabNames li").remove();
            $('#nooftasks').val(0);
            nodes.forEach(function(taskNode) {
                taskName = taskNode.getAttribute("name");
                generateTaskDiv(taskNode); // create respective Div for each task
                $("#page-content-wrapper #tabNames").append("<li class='taskDivHolder' ><a href='#" + taskName + "wrapper'>" + taskName + "</a></li>");
            });
            $("#page-content-wrapper #tabNames li:contains('+')").remove();
            $("#page-content-wrapper #tabNames li:contains('Undo')").remove();
            $("#page-content-wrapper #tabNames").append("<li><a id='addNewTask' href=''>+</a></li>");
            $("#page-content-wrapper #tabNames").append("<li><a id='undoNewTask' href=''>Undo</a></li>");
            $('#addNewTask').click(function() {
                addTask();
                addEvent("tabChange","page-content-wrapper "+ui.newTab.index(),xmlDom);
            });
            $('#undoNewTask').click(function() {
                executeEvent();
            });
            $("#page-content-wrapper").tabs();
            $("#page-content-wrapper").tabs("refresh");
        } catch (err) {
            handleError("Error initializing Tasks \n" + err);
        }
    });
}

var xmlDom;
var selectedindex = 0;
loadModel();
//createFile("ApproveClaim"); // todo  - Test and omit
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
        generateTasks();
        var text = new XMLSerializer().serializeToString((xmlDom));
        ExecuteCustomFunction("settext", text);
    } catch (err) {
        handleError("Error Saving Source \n"+err);
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
        generateUI("initial");
        setFocus();
        //$('.taskSection').slideUp(500);
        //$('.taskSection').collapse();
    } catch (err) {
        handleError(err);
    }
}

function loadModel() {
    try {
        xmlDom = marshalEditorTextContent(IDEGetFileContent());
    } catch (err) {
        handleError("Error Loading Model \n" + err);
    }
}

function loadModelWithText() {
    var contents = ExecuteCustomFunction("gettext");
    try {
        xmlDom = marshalEditorTextContent(contents);
    } catch (err) {
        handleError("Error Loading Model with text \n" + err);
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
    tasksList = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task");
    nodes = Array.prototype.slice.call(tasksList, 0);
    nodes.forEach(function(taskNode) {
        generateText(taskNode);
    });
}

/*
 * Signature: deleteTask(){...}
 * 
 * This method deletes an existing task.
 */
function deleteTask(taskNode) { //createFile
    if(taskNode.parentNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task").length!=1){
        confirmInput = confirm("Do you really want to delete " + taskNode.getAttribute("name") + " ? ");
        if (confirmInput == true) {
            taskNode.parentNode.removeChild(taskNode); 
            saveSource();
            process();
            ExecuteCustomFunction("removewsdl", taskNode.getAttribute("name"));
            makeDirty();
        } 
    }else{
        handleError("HT File should have at least one task");    
    }
}

/*
 * Signature: generateUI() {...}
 * 
 * This method iterates over the task nodes and creates the UI elements(using
 * generateTaskDiv function) for each task node in the human task dom.
 * 
 */
function generateUI(status) {
    if (xmlDom.childNodes.length == 1 && xmlDom.childNodes[0].childNodes == 0) {
        handleError("XML couldnt be parsed"); //Toggle Logic Here
        $('body').hide();
    } else {
        $('body').show();
        tasksList = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task");
        nodes = Array.prototype.slice.call(tasksList, 0);
        $("#page-content-wrapper #tabNames li").remove();
        $('#nooftasks').val(0);
        nodes.forEach(function(taskNode) {
            taskName = taskNode.getAttribute("name");
            if(status == "initial")
            generateTaskDiv(taskNode,status); // create respective Div for each task
            else
            generateTaskDiv(taskNode);    
            $("#page-content-wrapper #tabNames").append("<li class='taskDivHolder' ><a href='#" + taskName + "wrapper'>" + taskName + " </a><a id='deleteTask"+taskName+"' href='#" + taskName + "wrapper'>X</a></li>");
            $('#deleteTask'+taskName).click(function() {
                deleteTask(taskNode);
            });
        });
        $("#page-content-wrapper #tabNames li:contains('+')").remove();
        //$("#page-content-wrapper #tabNames li:contains('-')").remove();
        $("#page-content-wrapper #tabNames").append("<li><a id='addNewTask' data-toggle='tooltip' title='Create new task' href=''>+</a></li>");
        //$("#page-content-wrapper #tabNames").append("<li><a id='undoNewTask' href=''>-</a></li>");
        $('#addNewTask').click(function() {
            addTask();
        });
        /*$('#undoNewTask').click(function() {
           executeEvent();
        });*/
        $("#page-content-wrapper").tabs();
        $("#page-content-wrapper").tabs("refresh");
        $('#page-content-wrapper').tabs("option", "active", selectedindex);
        handleTabChange();
        bindToggleEvent();
    }
}

function bindSuggestion(taskName,availableTags){
    $( "#"+taskName+"wrapper .expression" ).autocomplete({
      source: availableTags
    });
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
function generateTaskDiv(taskNode, caller) {
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
    $('#' + taskDivName + " #taskName").val(taskName.trim().replace(/ /g, ''));
    $('#' + taskDivName + ' #taskName').change(function() {
        taskNameInput = $('#' + taskNode.getAttribute("name") + "wrapper #taskName").val();
        if(taskNameInput.trim()!=""){
        makeDirty();
        ExecuteCustomFunction("removewsdl", taskNode.getAttribute("name"));
        taskNode.setAttribute("name", taskNameInput);
        createFile(taskNode.getAttribute("name"),"");
        }else{
        handleError("Task name should not be empty");
        $('#' + taskNode.getAttribute("name") + "wrapper #taskName").val(taskNode.getAttribute("name"));
        makeUnDirty();
        }
        //generateTasks();
    });
    initValues(taskName);
    i = parseInt($('#nooftasks').val());
    //handleError(i);
    i++;
    $('#nooftasks').val(i);
    $('#' + taskDivName + ' input:radio').each(function() {
        radioName = $(this).attr("name");
        $(this).attr("name", radioName + taskDivName);
    });
    // Add input mapping row
    $('#' + taskDivName + " #addInput").off('click');

    $('#' + taskDivName + " #addInput")
        .off()
        .click(
            function(e) {
                // create DOM node for new input
                var inputNode = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
                    .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0];
                var newInputElement = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:element");
                newInputElement.setAttribute("id", ""); //place holder
                newLabel = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:label");
                newLabelText = xmlDom.createTextNode("");
                newLabel.appendChild(newLabelText);
                newInputElement.appendChild(newLabel);
                newValue = xmlDom.createElementNS(
                    "http://wso2.org/ht/schema/renderings/",
                    "wso2:value");
                newValueText = xmlDom.createTextNode("");
                newValue.appendChild(newValueText);
                newInputElement.appendChild(newValue);
                inputNode.appendChild(newInputElement);
                // bind click event
                e.preventDefault();
                var mappingNo = parseInt($('#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val());
                mapping = '<tr id="inputmapping' + mappingNo + '"><td><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="" placeholder="Element Name"></td><td><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="" placeholder="Display Name"></td><td><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="" placeholder="Value"></td><td><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';
                $(
                    "#" + taskNode.getAttribute("name") + "wrapper #inputmappingTable").append(
                    mapping);
                mappingNo++;
                $(
                    '#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val(
                    mappingNo);
                makeDirty();
                generateText(taskNode);
                generateTaskDiv(taskNode, "taskInputSection");
                //selectedindex = $('#page-content-wrapper a[href="#'+taskNode.getAttribute("name")+'wrapper"]').parent().index();
            });

    // Add output mapping row
    $('#' + taskDivName + " #addOutput")
        .off()
        .click(
            function(el) {
                try {
                    // create dom node
                    var outputNode = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
                        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0];
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
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="" placeholder="Element Name"></td><td><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="" placeholder="Display Name"></td><td><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="" placeholder="Value"></td><td><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="" placeholder="Default Value"></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                    $(
                            "#" + taskNode.getAttribute("name") + "wrapper #outputmappingTable")
                        .append(outputmapping);

                    outputmappingNo++;
                    $(
                            '#' + taskNode.getAttribute("name") + "wrapper #taskOutputMappingNo")
                        .val(outputmappingNo);

                } catch (err) {
                    handleError(err);
                }
                makeDirty();
                generateText(taskNode);
                generateTaskDiv(taskNode,"taskOutputSection");
                //selectedindex = $('#page-content-wrapper a[href="#'+taskNode.getAttribute("name")+'wrapper"]').parent().index();
            });

    // sync rendering values into input mapping table
    var inputNodes = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0].childNodes;
    var inputTags = [];    
    $("#" + taskDivName + " #inputmappingTable")
        .html('<thead> <th >Element Name</th><th>Display Name</th><th>Presentation Parameters</th><th>Type</th><th>Action</th></thead>');

    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != "#text") {
            try {
                var mappingNo = parseInt($(
                    '#' + taskDivName + " #taskMappingNo").val());
                if ((inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes.length != 0) && (inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes.length != 0))
                    mapping = '<tr id="inputmapping' + mappingNo + '"><td><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"/><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="' + inputNodes[i].getAttribute("id") + '"/></td><td><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="' + inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes[0].nodeValue + '"/></td><td><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="' + inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes[0].nodeValue.replace(/\$/g, '') + '"/></td><td><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></input></label></td></tr>';
                else
                    mapping = '<tr id="inputmapping' + mappingNo + '"><td><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"/><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="' + inputNodes[i].getAttribute("id") + '"/></td><td><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value=""/></td><td><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value=""/></td><td><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';
                $("#" + taskDivName + " #inputmappingTable").append(mapping);
                $('#' + taskDivName + ' #taskInputMappingType' + mappingNo).val(inputNodes[i].getAttribute("type"));
                //bind suggestion event
                inputTags.push("htd:getInput(\""+taskName+"Request\"):/tns:"+inputNodes[i].getAttribute("id"));
                // bind delete event
                $('#' + taskDivName + ' .inputDeleteButton')
                    .off()
                    .click(
                        function(er) {
                            er.preventDefault();
                            try {
                                k = i;
                                generateText(taskNode);
                                var deleteId = er.target.id.replace(
                                    /[^\d.]/g, '');
                                var deleteNodeId = 0;
                                for (j = 0; j < inputNodes.length; j++) {
                                    if (inputNodes[j].nodeName != "#text") {
                                        if (parseInt(deleteId) === deleteNodeId) {
                                            taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
                                                .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0]
                                                .removeChild(inputNodes[j]);
                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                makeDirty();
                                generateTaskDiv(taskNode, "taskInputSection");
                                //selectedindex = $('#page-content-wrapper a[href="#'+taskNode.getAttribute("name")+'wrapper"]').parent().index();
                            } catch (err) {
                                handleError(err);
                            }
                        });
                mappingNo++;
                $('#' + taskDivName + " #taskMappingNo").val(mappingNo);
            } catch (err) {
                handleError(err);
            }
        }
    }

    // sync output rendering values into output mapping table
    var outputNodes = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0].childNodes;
    $("#" + taskDivName + " #outputmappingTable")
        .html('<thead><th>Element Name</th><th>Display Name</th><th>Value</th><th>Type</th><th>Default Values</th><th>Action</th></thead>');
    for (i = 0; i < outputNodes.length; i++) {
        if (outputNodes[i].nodeName != "#text") {
            try {
                var outputmappingNo = parseInt($(
                    '#' + taskDivName + " #taskOutputMappingNo").val());
                if ((outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes.length != 0) && (outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes.length != 0))
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="' + outputNodes[i].getAttribute("id") + '"></td><td><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes[0].nodeValue + '"></td><td><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes[0].nodeValue + '"></td><td><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","default")[0].childNodes[0].nodeValue + '"></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                else
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="' + outputNodes[i].getAttribute("id") + '"></td><td><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value=""></td><td><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value=""></td><td><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="xsd:string" selected>string</option><option value="xsd:int">int</option><option value="xsd:double">double</option><option value="xsd:float">float</option><option value="xsd:boolean">boolean</option><option value="htt:tOrganizationalEntity">organizationalEntity</option></select></label></td><td><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value=""></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                $("#" + taskDivName + " #outputmappingTable").append(
                    outputmapping);
                $('#' + taskDivName + ' #taskOutputMappingType' + mappingNo).val(outputNodes[i].getAttribute("type"));
                // bind delete event
                $('#' + taskDivName + ' .outputDeleteButton')
                    .off()
                    .click(
                        function(eo) {
                            eo.preventDefault();
                            try {
                                k = i;
                                generateText(taskNode);
                                var deleteId = eo.target.id.replace(
                                    /[^\d.]/g, '');
                                var deleteNodeId = 0;
                                for (j = 0; j < outputNodes.length; j++) {
                                    if (outputNodes[j].nodeName != "#text") {
                                        if (parseInt(deleteId) === deleteNodeId) {
                                            taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
                                                .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0]
                                                .removeChild(outputNodes[j]);
                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                makeDirty();
                                generateTaskDiv(taskNode,"taskOutputSection");
                                //selectedindex = $('#page-content-wrapper a[href="#'+taskNode.getAttribute("name")+'wrapper"]').parent().index();
                            } catch (err) {
                                handleError(err);
                            }
                        });
                outputmappingNo++;
                $('#' + taskDivName + " #taskOutputMappingNo").val(
                    outputmappingNo);
            } catch (err) {
                handleError(err);
            }
        }
    }
    //handleError($('#' +taskDivName + ' #taskCallbackServiceName').val());
    // sync other fields
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation").length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation")[0].hasChildNodes()) {
        $('#' + taskDivName + " #taskDocumentation")
            .val(
                taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation")[0].childNodes[0].nodeValue.trim());
    }
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority").length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority")[0].hasChildNodes()) {
        $('#' + taskDivName + " #taskPriority")
            .val(
                taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority")[0].childNodes[0].nodeValue.trim());
    }
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface").length != 0 && !taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].hasChildNodes()) {
        $('#' + taskDivName + " #taskOperation").val(
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].getAttribute(
                "operation").trim());
    }
    // service URL mapping
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].getAttribute(
            "responseOperation").trim() != "")
    $('#' + taskDivName + " #taskCallbackOperationName").val(
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].getAttribute(
            "responseOperation").trim());
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name").length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name")[0].hasChildNodes()) {
        $('#' + taskDivName + " #presentationElementDisplayName").val(
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name")[0].childNodes[0].nodeValue.trim());
    }
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject").length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject")[0].hasChildNodes()) {
        $('#' + taskDivName + " #presentationElementDisplaySubject").val(
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject")[0].childNodes[0].nodeValue.trim());
    }
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description").length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
                .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description")[0].hasChildNodes()) {
        $('#' + taskDivName + " #presentationElementDescription")
            .val(
                taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
                .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description")[0].childNodes[0].nodeValue.trim());
    }
    
    try {
        // sync People assignments potential owners
        unmarshalPeopleAssignment(taskNode, "potentialOwners");

        // sync People assignments businessAdministrators
        unmarshalPeopleAssignment(taskNode, "businessAdministrators");

        // sync People assignments excludedOwners
        unmarshalPeopleAssignment(taskNode, "excludedOwners");

        // sync People assignments taskInitiator
        unmarshalPeopleAssignment(taskNode, "taskInitiator");

        // sync People assignments taskStakeholders
        unmarshalPeopleAssignment(taskNode, "taskStakeholders");

    } catch (err) {
        handleError("Could not sync people assignments \n" + err);
    }
    $('#' + taskDivName + ' .taskDiv').show();
    bindChangeEvents();
    syncWSDLFields(taskName);
    if(caller == "initial"){
        $('#' + taskDivName + ' #taskPropertiesSection').collapse('show');
    }
    $('#' + taskDivName + ' #' + caller).collapse('show');
    bindSuggestion(taskName,inputTags);
    //syncwsdlFields syncWSDLFields(taskNode);
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
    taskNode.setAttribute("name", $('#' + taskDivName + " #taskName").val().replace(/ /g, ''));
    createImportNodes(taskName);
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation")[0].hasChildNodes())
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskDocumentation").val(); //else create node and add
    else
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","documentation")[0].appendChild(xmlDom.createTextNode($(
        '#' + taskDivName + " #taskDocumentation").val()));
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority")[0].hasChildNodes())
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskPriority").val();
    else
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","priority")[0].appendChild(xmlDom.createTextNode($(
        '#' + taskDivName + " #taskPriority").val()));
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name")[0].hasChildNodes())
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDisplayName").val();
    else
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","name")[0].appendChild(xmlDom.createTextNode($(
        '#' + taskDivName + " #presentationElementDisplayName").val()));    
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject")[0].hasChildNodes())    
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDisplaySubject").val();
    else
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","subject")[0].appendChild(xmlDom.createTextNode($(
        '#' + taskDivName + " #presentationElementDisplaySubject").val()));    
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description")[0].hasChildNodes())    
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #presentationElementDescription").val();
    else
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","description")[0].appendChild(xmlDom.createTextNode($(
        '#' + taskDivName + " #presentationElementDescription").val()));    
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].setAttribute("operation", $(
        '#' + taskDivName + " #taskOperation").val());
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].setAttribute(
        "responseOperation", $(
            '#' + taskDivName + " #taskCallbackOperationName").val())
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].setAttribute("portType", "tns:" +
        taskName + "PT");
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","interface")[0].setAttribute(
            "responsePortType", "tns:" + taskName + "CBPT")
        // fill input mappings
    inputmappingNo = parseInt($('#' + taskDivName + " #taskMappingNo").val());
    inputNodes = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0].childNodes;
    inputmapping = 0;
    presentationParametersa = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationParameters")[0];
    while (presentationParametersa.firstChild) {
                    presentationParametersa.removeChild(presentationParametersa.firstChild);
    }
    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != '#text') {
            inputNodes[i].setAttribute("id", $(
                '#' + taskDivName + " #taskInputMappingElementName" + inputmapping).val());
            if (inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes.length != 0)
                inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskInputMappingDisplayName" + inputmapping).val();
            else
                addTextNode(inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0], xmlDom, $('#' + taskDivName + " #taskInputMappingDisplayName" + inputmapping).val());
            inputNodes[i].setAttribute("type", $(
                '#' + taskDivName + " #taskInputMappingType" + inputmapping).val());
            if (inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes.length != 0)
                inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes[0].nodeValue = '$' + $(
                    '#' + taskDivName + " #taskInputMappingOrder" + inputmapping).val() + '$';
            else
                addTextNode(inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0], xmlDom, $('#' + taskDivName + " #taskInputMappingOrder" + inputmapping).val());
                addPresentationParameter(xmlDom,taskNode,taskName,inputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes[0].nodeValue,inputNodes[i].getAttribute("type"));
             
            inputmapping++;
        }
    }

    // fill output mappings
    outputmappingNo = parseInt($('#' + taskDivName + " #taskOutputMappingNo")
        .val());
    outputNodes = taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0]
        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0].childNodes;
    outputmapping = 0;
    for (i = 0; i < outputNodes.length; i++) {
        if (outputNodes[i].nodeName != '#text') {
            outputNodes[i].setAttribute("id", $(
                '#' + taskDivName + " #taskOutputMappingElementName" + outputmapping).val());
            if (outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingDisplayName" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","label")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingDisplayName" + outputmapping).val());
            outputNodes[i].setAttribute("type", $(
                '#' + taskDivName + " #taskOutputMappingType" + outputmapping).val());
            if (outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingOrder" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","value")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingOrder" + outputmapping).val());
            if (outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","xpath")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","xpath")[0].childNodes[0].nodeValue = "/tns:" + taskName + "CBData/tns:" + $(
                    '#' + taskDivName + " #taskOutputMappingElementName" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","xpath")[0], xmlDom, "/tns:" + taskName + "CBData/tns:" + $('#' + taskDivName + " #taskOutputMappingElementName" + outputmapping).val());
            if (outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","default")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","default")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingDefaultValues" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","default")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingDefaultValues" + outputmapping).val());
            outputmapping++;
        }
    }

    // fill people assignments - potentialOwners
    marshalPeopleAssignment(taskNode,"potentialOwners");

    // fill people assignments - Business Admin
    marshalPeopleAssignment(taskNode,"businessAdministrators");
        
    // fill people assignments - Excluded Owners
    marshalPeopleAssignment(taskNode,"excludedOwners");

    // fill people assignments - taskInitiator
    marshalPeopleAssignment(taskNode,"taskInitiator");

    // fill people assignments - taskStakeholders
    marshalPeopleAssignment(taskNode,"taskStakeholders");

    //Remove people assignments with no argument or argument value none
    var peopleAssignmentsList = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].childNodes;
    for (i = 0; i < peopleAssignmentsList.length; i++) {
        if (peopleAssignmentsList[i].nodeName != "#text") {
            if (peopleAssignmentsList[i].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument").length != 0 && peopleAssignmentsList[i].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0].getAttribute("name") == "None") {
                taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].removeChild(peopleAssignmentsList[i]);
            }
        }
    }
    setMetaRendering(taskNode);
    createFile(taskName,"generateText",taskNode);
}


function getArgumentName(nameValue) {
    if (nameValue) {
        if (nameValue.indexOf("Role") != -1)
            return "role";
        else if (nameValue.indexOf("Literal") != -1)
            return "literal";
        else if (nameValue.indexOf("Expression") != -1)
            return "expression";
        else
            return "None";
    } else {
        return "None";
    }
}

function createImportNodes(taskName){
    importNodes = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","import");
    for (i = 0; i < importNodes.length; i++) {
       xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","humanInteractions")[0].removeChild(importNodes[i]);
    }
    newTaskImport = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:import");
    newTaskImport.setAttribute("location",taskName+"Task.wsdl");
    newTaskImport.setAttribute("namespace",xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","humanInteractions")[0].getAttribute("xmlns:tns"));
    newTaskImport.setAttribute("importType","http://schemas.xmlsoap.org/wsdl/");
    xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","humanInteractions")[0].appendChild(newTaskImport);
    newCBTaskImport = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:import");
    newCBTaskImport.setAttribute("location",taskName+"TaskCallBack.wsdl");
    newCBTaskImport.setAttribute("namespace",xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","humanInteractions")[0].getAttribute("xmlns:tns"));
    newCBTaskImport.setAttribute("importType","http://schemas.xmlsoap.org/wsdl/");
    xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","humanInteractions")[0].appendChild(newCBTaskImport);
 }

function setMetaRendering(taskNode) {
    //copynode to wso2metadata
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs").length !=0 ){ //check for type=wso2:input
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[0].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0]);
    }
    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[1].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs").length !=0 ){ //check for type=wso2:output
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[1].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0]);
    }
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[0].appendChild(xmlDom.importNode(taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0], true));
    taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","rendering")[1].appendChild(xmlDom.importNode(taskNode.getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","metadata")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","outputs")[0], true));
    //remove orgentitynodes from renderings
    var inputNodes = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0]
        .getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0].childNodes;
    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != "#text") {
            if(inputNodes[i].getAttribute("type") == "htt:tOrganizationalEntity"){
                taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","renderings")[0].getElementsByTagNameNS("http://wso2.org/ht/schema/renderings/","inputs")[0].removeChild(inputNodes[i]);
            }
        }
    }
}

/*
 * Signature: marshalEditorTextContent(textContent) {...}
 * 
 * This method marshals the text content into a xmlDom object
 * 
 */

function marshalEditorTextContent(textContent) {
    try {
        var parser = new DOMParser();
        var root = parser.parseFromString(textContent, "text/xml");
    } catch (err) {
        handleError("Marshalling Error \n" + err.message);
    }
    return root;
}

function syncWSDLFields(taskName){
    taskDivName = taskName + "wrapper";
    try {
        var wsdlRead = readCBWSDL(taskName);
    } catch (err) {
        handleError("Error Reading WSDL");
    }
    if (typeof wsdlRead != 'undefined' || wsdlRead != 'undefined') {
        if(wsdlRead.getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","definitions").length!=0){
            if(wsdlRead.getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","definitions")[0].getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/soap/","address")[0].getAttribute("location")!='undefined')
            $('#' + taskDivName + ' #taskCallbackServiceURL').val(wsdlRead.getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","definitions")[0].getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/soap/","address")[0].getAttribute("location"));
            if(wsdlRead.getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","definitions")[0].getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","service")[0].getAttribute("name")!='undefined')
            $('#' + taskDivName + ' #taskCallbackServiceName').val(wsdlRead.getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","definitions")[0].getElementsByTagNameNS("http://schemas.xmlsoap.org/wsdl/","service")[0].getAttribute("name"));
        }else{
            createFile(taskName,"initial");
        }
    }
}

/*
 * Signature: loadFileContent() {...}
 * 
 * This loads relevant file's content from IDE
 * 
 */
function loadFileContent() {
    var fileContent = IDEGetFileContent();
}

/*
 * Signature: addPeopleAssignementNode(taskNode, xmlDom, assignmentName)  {...}
 * 
 * This function adds a people assignment node to the relevant taskNode
 * 
 */
function addPeopleAssignementNode(taskNode, xmlDom, assignmentName) {
    try {
        if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",assignmentName).length != 0)
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",assignmentName)[0]);
        var newAssignmentNode = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:" + assignmentName);
        newFrom = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:from");
        newArgument = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:argument");
        newArgument.setAttribute("name", "role");
        //newFrom.setAttribute("logicalPeopleGroup", "");
        newArgumentText = xmlDom.createTextNode("regionalClerksRole");
        newArgument.appendChild(newArgumentText);
        newFrom.appendChild(newArgument);
        newAssignmentNode.appendChild(newFrom);
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].appendChild(newAssignmentNode);
    } catch (err) {
        handleError(err);
    }
}

/*
 * Signature: addExpressionNode(taskNode, xmlDom, assignmentName)  {...}
 * 
 * This function adds a people assignment expression node to the relevant taskNode
 * 
 */
function addExpressionNode(taskNode, xmlDom, assignmentName) {
    try {
        if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",assignmentName).length != 0)
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",assignmentName)[0]);
        var newAssignmentNode = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:" + assignmentName);
        newFrom = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:from");
        newFromText = xmlDom.createTextNode("regionalClerksExpression");
        newFrom.appendChild(newFromText);
        newAssignmentNode.appendChild(newFrom);
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].appendChild(newAssignmentNode);
    } catch (err) {
        handleError(err);
    }
}

/*
 * Signature: addGeneralNode(taskNode, xmlDom, assignmentName)  {...}
 * 
 * This function adds a people assignment node to the relevant taskNode
 * 
 */
function addGeneralNode(taskNode, xmlDom, nodeName) {
    try {
        var newNode = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:" + nodeName);
        newFrom = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:from");
        newArgument = xmlDom.createElementNS(
            "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
            "htd:argument");
        newArgument.setAttribute("name", "role");
        //newFrom.setAttribute("logicalPeopleGroup", "");
        newArgumentText = xmlDom.createTextNode("regionalClerksRole");
        newArgument.appendChild(newArgumentText);
        newFrom.appendChild(newArgument);
        newAssignmentNode.appendChild(newFrom);
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].appendChild(newAssignmentNode);
    } catch (err) {
        handleError(err);
    }
}

/*
 * Signature: addTextNode(parentNode, xmlDom, content)  {...}
 * 
 * This function adds a text node to any parent node provided
 * 
 */
function addTextNode(parentNode, xmlDom, content) {
    newText = xmlDom.createTextNode(content);
    parentNode.appendChild(newText);
}

function bindToggleEvent(){
$('.sectionHeader').click(function() {
    //$(this).parent().find('.taskSection').slideToggle(500);
     $(this).parent().find('.taskSection').collapse('toggle'); 
     $(this).parent().siblings().find('.taskSection').collapse('hide');
});
}

function marshalPeopleAssignment(taskNode, peopleAssignmentName) {
    taskName = taskNode.getAttribute("name");
    taskDivName = taskName + "wrapper";
    /*if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName).length != 0 &&
        $('#' + taskDivName + " input[name = " + peopleAssignmentName + "" + taskDivName + "]:checked").val() == "na"){
        emptyNode(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]);
    }*/ // 
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName).length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument").length != 0 && $('#' + taskDivName + " input[name = " + peopleAssignmentName + "" + taskDivName + "]:checked").val() == peopleAssignmentName+ "Role"){
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0]
        .setAttribute(
            "name",
            getArgumentName($(
                    '#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked")
                .val()));
    }else {
        if ($('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName + "Role" || 
            $('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName + "Literal") {
            addPeopleAssignementNode(taskNode, xmlDom, peopleAssignmentName);
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0]
                .setAttribute(
                    "name",
                    getArgumentName($(
                            '#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked")
                        .val()));
        } else if ($('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName+ "Expression") {
            addExpressionNode(taskNode, xmlDom, peopleAssignmentName);
        } 
    }

    if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName).length != 0 && taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument").length != 0 ){
    if ($('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName+ "Role"){
        if($('#' + taskDivName + " #" + peopleAssignmentName + "Role").val().trim() != ""){
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #" + peopleAssignmentName + "Role").val();
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0].setAttribute("logicalPeopleGroup", $(
            '#' + taskDivName + " #" + peopleAssignmentName + "RoleLogicalGroup").val());
        }
        else{
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]);
        }
    }
    }
    if ($('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName+ "Expression")
        if($('#' + taskDivName + " #"+peopleAssignmentName+ "Expression").val().trim() != ""){
        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #"+peopleAssignmentName+ "Expression").val();
        }
        else{
            taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]);
        }
    if ($('#' + taskDivName + " input[name="+peopleAssignmentName+ "" + taskDivName + "]:checked").val() == peopleAssignmentName+ "Literal") {
        // taskNode.removeChild(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]);
        createNewLiteral(xmlDom, taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0], $('#' + taskDivName + " #"+peopleAssignmentName+"LiteralUsers").val().trim(),$('#' + taskDivName + " #"+peopleAssignmentName+"LiteralGroups").val().trim());
    }
}

function unmarshalPeopleAssignment(taskNode, peopleAssignmentName) {
    taskName = taskNode.getAttribute("name");
    taskDivName = taskName + "wrapper";
    if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
            .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName).length != 0) { //&& TaskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","potentialOwners").getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument").length!=0
            if (taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument").length != 0) {
                ownerType = toTitleCase(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                    .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                    .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0].getAttribute("name"));
                $('#' + taskDivName + " input[name="+peopleAssignmentName+""+ taskDivName + "][value="+peopleAssignmentName+"" + ownerType + "]").prop("checked", true);
                if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0].childNodes.length != 0)
                $('#' + taskDivName + " #"+peopleAssignmentName+"" + ownerType)
                    .val(
                        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","argument")[0].childNodes[0].nodeValue.trim());
                if(ownerType == "Role"){ //removeexpression
                    $('#' + taskDivName + " #" + peopleAssignmentName + "" + ownerType + "LogicalGroup").val(
                        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0].getAttribute("logicalPeopleGroup"))
                }    
            } else {
                if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0].getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","literal").length != 0){
                    $('#' + taskDivName + " input[name="+peopleAssignmentName+"" + taskDivName + "][value="+peopleAssignmentName+"Literal]").prop("checked", true);
                    usersList = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803","user");
                    groupsList = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803","group");
                    for (var t = 0; t < usersList.length; t++) {
                        if(usersList[t].childNodes.length!=0){
                            if($('#' + taskDivName + " #"+peopleAssignmentName+"LiteralUsers").val().trim() == "") $('#' + taskDivName + " #"+peopleAssignmentName+"LiteralUsers").val(usersList[t].childNodes[0].nodeValue);
                            else $('#' + taskDivName + " #"+peopleAssignmentName+"LiteralUsers").val($('#' + taskDivName + " #"+peopleAssignmentName+"LiteralUsers").val() + ',' + usersList[t].childNodes[0].nodeValue);
                        }
                    }
                    for (var k = 0; k < groupsList.length; k++) {
                        if(groupsList[k].childNodes.length!=0){
                            if($('#' + taskDivName + " #"+peopleAssignmentName+"LiteralGroups").val().trim() == "") $('#' + taskDivName + " #"+peopleAssignmentName+"LiteralGroups").val(groupsList[k].childNodes[0].nodeValue);
                            else $('#' + taskDivName + " #"+peopleAssignmentName+"LiteralGroups").val($('#' + taskDivName + " #"+peopleAssignmentName+"LiteralGroups").val() + ',' + groupsList[k].childNodes[0].nodeValue);
                        }
                    }
                }
                else{ // for expression
                    $('#' + taskDivName + " input[name="+peopleAssignmentName+""+ taskDivName + "][value="+peopleAssignmentName+"Expression]").prop("checked", true);
                if(taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0].childNodes.length != 0)
                $('#' + taskDivName + " #"+peopleAssignmentName+"Expression")
                    .val(
                        taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","peopleAssignments")[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",peopleAssignmentName)[0]
                        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","from")[0].childNodes[0].nodeValue.trim());
                }
            }
        } else {
            $('#' + taskDivName + " input[name="+peopleAssignmentName+"" + taskDivName + "][value=na]").prop("checked", true);
        }
}


function bindChangeEvents() { //put all the listeners here

    $('input').keyup(function(e) {
        if((e.ctrlKey && e.which != 86) || (e.ctrlKey && e.which === 83)){ //avoid reacting for ctrl+s and ctrl+v
            return false;
        }else{
            if(this.id.indexOf("taskInputMappingElementName") > -1){
                text = this.id.replace("taskInputMappingElementName", "taskInputMappingOrder");
                $('#' + taskDivName + " #" + text).val($(this).val());
            }
            makeDirty();
        }
        //generateText();
    });
    $('textarea').keyup(function(e) {
        if(e.ctrlKey || (e.ctrlKey && e.which === 83)){
            return false;
        }else{
            if(this.id.indexOf("taskInputMappingElementName") > -1){
                text = this.id.replace("taskInputMappingElementName", "taskInputMappingOrder");
                $('#' + taskDivName + " #" + text).val($(this).val());
            }
            makeDirty();
        }
        //generateTasks();
    });
    $('select').change(function() {
        makeDirty();
        //generateTasks();
    });
    $('input:radio').change(function() {
        makeDirty();
        //generateTasks();
    });
}

function createNewLiteral(xmlDom, parent, text, grouptext) {
    while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
    }
    var splitList = text.split(",");
    var groupSplitList = grouptext.split(",");
    newLiteral = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
        "htd:literal"); // scheme.appendchild()
    newOrgEntity = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
        "htt:tOrganizationalEntity");
    for (var i = 0; i < splitList.length; i++) {
           newUser = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
                "htt:user");
            newUserText = xmlDom.createTextNode(splitList[i]);
            newUser.appendChild(newUserText);
            newOrgEntity.appendChild(newUser);
   }
    for (var i = 0; i < groupSplitList.length; i++) {
            
            newGroup = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
                "htt:group");
            newGroupText = xmlDom.createTextNode(groupSplitList[i]);
            newGroup.appendChild(newGroupText);
            newOrgEntity.appendChild(newGroup);
    }
    newLiteral.appendChild(newOrgEntity);
    parent.appendChild(newLiteral);
}

function createNewRole(xmlDom, parent, text, grouptext) {
    while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
    }
    var splitList = text.split(",");
    var groupSplitList = grouptext.split(",");
    for (var i = 0; i < splitList.length; i++) {
           newUser = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
                "htd:argument");
            newUserText = xmlDom.createTextNode(splitList[i]);
            newUser.appendChild(newUserText);
            parent.appendChild(newUser);
   }
}

function addPresentationParameter(xmlDom, taskNode, taskName , name, type) { //should be presentationParameters
    //if(name.indexOf("$")==0 && name.lastIndexOf("$")==(name.length-1)){ //uncomment this for $ validation
    if(type != "htt:tOrganizationalEntity"){
    name = name.replace(/[&\/\\#,+()$~%.'":*?<>{}]/g, '');
    parent = taskNode.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationElements")[0]
        .getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","presentationParameters")[0];
    newPresentationParameter = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
        "htd:presentationParameter"); 
    newPresentationParameter.setAttribute("name",name);   
    newPresentationParameter.setAttribute("type",type); 
    //newPresentationParameterText = xmlDom.createTextNode("htd:getInput(\""+taskName+"Request\")/test10:"+name);
    newPresentationParameterText = xmlDom.createTextNode("htd:getInput(\""+taskName+"Request\")/tns:" + name);
    newPresentationParameter.appendChild(newPresentationParameterText);
    parent.appendChild(newPresentationParameter);
    }
   // }
}

function removeUnwantedArtifacts() {
    var taskNames = ["removeWSDL"];
    tasksList = xmlDom.getElementsByTagNameNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803","task");
    nodes = Array.prototype.slice.call(tasksList, 0);
    nodes.forEach(function(taskNode) {
        taskNames.push(taskNode.getAttribute("name"));
    });
    ExecuteCustomFunction.apply(this, taskNames);
}

function initValues(currentTaskName) {
    $('#' + currentTaskName + 'wrapper #taskCallbackServiceName').val(currentTaskName+"Result");
    $('#' + currentTaskName + 'wrapper #taskCallbackOperationName').val(currentTaskName+"Response");
    $('#' + currentTaskName + 'wrapper #taskCallbackServiceURL').val("http://localhost:9763/service/"+currentTaskName+"Result");
}

function handleError(message) {
    //alert(message); // A functionality to log errors is requested in https://wso2.org/jira/browse/TOOLS-3366
    ExecuteCustomFunction("alert", "Human task editor error", message);
}

function handleTabChange() {
    $("#page-content-wrapper").tabs({ activate: function(event ,ui){
            selectedindex = ui.newTab.index();
            //addEvent("tabChange","page-content-wrapper "+ui.newTab.index(),xmlDom);
        } 
    });
}

function emptyNode(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}

//Undo Redo Implementation
/* There are 3 kind of events used in the editor
 1) text events (eventID,textelementID)
 2) table add row events (eventID,rowID)
 3) radiobuttonselect events (eventID,radiobuttonID)    
*/

var eventStack = [];

function addEvent(eventType, elementID, elementValue){
    lastEventID =  parseInt(getLastEventID());
    lastEventID++;
    newElement = [lastEventID,eventType,elementID,elementValue.cloneNode(true)];
    eventStack.push(newElement);
}

function getLastEventID(){
    lastElement = eventStack.pop();
    lastElementID = 0;
    if (typeof lastElement == 'undefined') lastElementID = 0;
    else lastElementID = lastElement[0];
    return lastElementID;
}

function getEvent(){
    lastElement = eventStack.pop();
    return lastElement;
}

function executeEvent(){
    lastElement = getEvent();
    lastElementEventType = lastElement[1];
    xmlDom = lastElement[3];
    process();
}

function setFocus(){
    // Set focus to editor part in IDE,
    // You can call this function when 
    // the main html component of your editor
    // gets the focus. This is important because
    // if the editor is not in focus, you won't
    // be able to capture key strokes etc.
    IDESetFocusToEditorPart();
}
