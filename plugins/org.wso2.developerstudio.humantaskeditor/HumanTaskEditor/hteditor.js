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
function createFile(currentTaskName) { //createFile
    alert(currentTaskName);
    // Create Task WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlDom = marshalEditorTextContent(data);
            generateInputWSDL(wsdlDom, currentTaskName);
            saveWSDL(wsdlDom, currentTaskName + "Task");
        } catch (err) {
            alert("wsdl"+err);
        }

    });
    // Create Task Callback WSDL
    $.get('resources/dummy.wsdl', function(data) {
        try {
            wsdlCBDom = marshalEditorTextContent(data);
            generateOutputWSDL(wsdlCBDom, currentTaskName);
            saveWSDL(wsdlCBDom, currentTaskName + "CBTask");
            // generateUI();
           
        } catch (err) {
            alert("wsdlCBDomB"+err);
        }

    });

    $.get('resources/dummyhtconfig.ht', function(data) {
       
        try {
            htconfigDom = marshalEditorTextContent(data);
            generateHTConfig(htconfigDom,xmlDom, currentTaskName);
            saveHTConfig(htconfigDom);

        } catch (err) {
            alert("config"+err);
        }

    });
}

function readCBWSDL(currentTaskName) { //createFile
    try{
    var cbWsdl = ExecuteCustomFunction("getWSDL", currentTaskName); 
    }catch(err){
        alert(cbWsdl);
        alert('Error Reading CallBack WSDL');
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
    $.get('resources/dummytask.ht', function(data) {
        try {
            taskPartDom = marshalEditorTextContent(data);
            tasks = xmlDom.getElementsByTagName("tasks")[0];
            i = parseInt($('#nooftasks').val());
            createFile("newTask" + i);
            taskPartDom.getElementsByTagName("task")[0].setAttribute("name", "newTask" + i);
            xmlDom.getElementsByTagName("tasks")[0].appendChild(xmlDom.importNode(taskPartDom.getElementsByTagName("task")[0], true));
            IDESaveContent(new XMLSerializer().serializeToString((xmlDom)));
            generateUI();
           
        } catch (err) {
            alert("addTask"+err);
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
    $.get('resources/dummy.ht', function(data) {
        try {
            xmlDom = marshalEditorTextContent(data);
            IDESaveContent(data);
            tasksList = xmlDom.getElementsByTagName("task");
            nodes = Array.prototype.slice.call(tasksList, 0);
            $("#page-content-wrapper #tabNames li").remove();
            $('#nooftasks').val(0);
            nodes.forEach(function(taskNode) {
                taskName = taskNode.getAttribute("name");
                generateTaskDiv(taskNode); // create respective Div for each task
                $("#page-content-wrapper #tabNames").append("<li class='taskDivHolder' ><a href='#" + taskName + "wrapper'>" + taskName + "</a></li>");
            });
            $("#page-content-wrapper #tabNames li:contains('+')").remove();
            $("#page-content-wrapper #tabNames").append("<li><a id='addNewTask' href=''>+</a></li>");
            $('#addNewTask').click(function() {
                addTask();
            });

            $("#page-content-wrapper").tabs();
            $("#page-content-wrapper").tabs("refresh");
        } catch (err) {
            alert("initial"+err);
        }

    });
}

var xmlDom;
loadModel();
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

function loadModel() {
    try {
        xmlDom = marshalEditorTextContent(IDEGetFileContent());

    } catch (err) {
        alert("LoadModel"+err);
    }
}

function loadModelWithText() {
    var contents = ExecuteCustomFunction("gettext");
    try {
        xmlDom = marshalEditorTextContent(contents);

    } catch (err) {
        alert("loadmodelwithtext"+err);
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
    //removeUnwantedArtifacts();
}

/*
 * Signature: generateUI() {...}
 * 
 * This method iterates over the task nodes and creates the UI elements(using
 * generateTaskDiv function) for each task node in the human task dom.
 * 
 */
function generateUI() {
    if (xmlDom.childNodes.length == 1 && xmlDom.childNodes[0].nodeValue == null) {
        alert("XML couldnt be parsed");
        $('body').hide();
    } else {
        $('body').show();
        tasksList = xmlDom.getElementsByTagName("task");
        nodes = Array.prototype.slice.call(tasksList, 0);
        $("#page-content-wrapper #tabNames li").remove();
        $('#nooftasks').val(0);
        nodes.forEach(function(taskNode) {
            taskName = taskNode.getAttribute("name");
            generateTaskDiv(taskNode); // create respective Div for each task

            $("#page-content-wrapper #tabNames").append("<li class='taskDivHolder' ><a href='#" + taskName + "wrapper'>" + taskName + "</a></li>");
        });
        $("#page-content-wrapper #tabNames li:contains('+')").remove();
        $("#page-content-wrapper #tabNames").append("<li><a id='addNewTask' href=''>+</a></li>");
        $('#addNewTask').click(function() {
            addTask();
        });
        $("#page-content-wrapper").tabs();
        $("#page-content-wrapper").tabs("refresh");
    }


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
    $('#' + taskDivName + " #taskName").val(taskName.trim().replace(/ /g, ''));
    $('#' + taskDivName +' #taskName').change(function() {
        
        createFile($('#' + taskNode.getAttribute("name") + "wrapper #taskName").val());
        makeDirty();
        taskNode.setAttribute("name",$('#' + taskNode.getAttribute("name") + "wrapper #taskName").val());
        generateUI();
        //generateTasks();
    });

    i = parseInt($('#nooftasks').val());
    //alert(i);
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
                var inputNode = taskNode.getElementsByTagName("renderings")[0]
                    .getElementsByTagName("inputs")[0];
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
                mapping = '<tr id="inputmapping' + mappingNo + '"><td width="25%"><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="" placeholder="Element Name"></td><td width="25%"><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="" placeholder="Display Name"></td><td width="10%"><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="" placeholder="Value"></td><td width="20%"><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';
                $(
                    "#" + taskNode.getAttribute("name") + "wrapper #inputmappingTable").append(
                    mapping);
                mappingNo++;
                $(
                    '#' + taskNode.getAttribute("name") + "wrapper #taskMappingNo").val(
                    mappingNo);
                makeDirty();
                generateText(taskNode);
                generateTaskDiv(taskNode);
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
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td width="25%"><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="" placeholder="Element Name"></td><td width="25%"><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="" placeholder="Display Name"></td><td width="10%"><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="" placeholder="Value"></td><td width="20%"><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td width="10%"><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="" placeholder="Default Value"></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                    $(
                            "#" + taskNode.getAttribute("name") + "wrapper #outputmappingTable")
                        .append(outputmapping);
                   
                    outputmappingNo++;
                    $(
                            '#' + taskNode.getAttribute("name") + "wrapper #taskOutputMappingNo")
                        .val(outputmappingNo);

                } catch (err) {
                    alert(err);
                }
                makeDirty();
                generateText(taskNode);
                generateTaskDiv(taskNode);
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
                if ((inputNodes[i].getElementsByTagName("label")[0].childNodes.length != 0) && (inputNodes[i].getElementsByTagName("value")[0].childNodes.length != 0))
                    mapping = '<tr id="inputmapping' + mappingNo + '"><td width="25%"><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"/><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="' + inputNodes[i].getAttribute("id") + '"/></td><td width="25%"><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value="' + inputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue + '"/></td><td width="10%"><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value="' + inputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue + '"/></td><td width="20%"><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></input></label></td></tr>';
                else
                    mapping = '<tr id="inputmapping' + mappingNo + '"><td width="25%"><input name="taskInputMappingid" type="hidden" id="taskInputMappingid" value="' + mappingNo + '"/><input name="textfield6" type="text" id="taskInputMappingElementName' + mappingNo + '" value="' + inputNodes[i].getAttribute("id") + '"/></td><td width="25%"><input name="textfield7" type="text" id="taskInputMappingDisplayName' + mappingNo + '" value=""/></td><td width="10%"><input name="textfield8" type="text" id="taskInputMappingOrder' + mappingNo + '" value=""/></td><td width="20%"><label><select id="taskInputMappingType' + mappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td><label><input type="button" class="inputDeleteButton btn btn-danger" name="deleteButton' + mappingNo + '" id="deleteButton' + mappingNo + '" value="Delete"></label></td></tr>';

                $("#" + taskDivName + " #inputmappingTable").append(mapping);
                $('#' + taskDivName + ' #taskInputMappingType' + mappingNo).val(inputNodes[i].getAttribute("type").replace("xsd:", ""));
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
                                            taskNode
                                                .getElementsByTagName("renderings")[0]
                                                .getElementsByTagName("inputs")[0]
                                                .removeChild(inputNodes[j]);

                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                makeDirty();
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
                if ((outputNodes[i].getElementsByTagName("label")[0].childNodes.length != 0) && (outputNodes[i].getElementsByTagName("value")[0].childNodes.length != 0))
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td width="25%"><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="' + outputNodes[i].getAttribute("id") + '"></td><td width="25%"><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue + '"></td><td width="10%"><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue + '"></td><td width="20%"><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td width="10%"><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value="' + outputNodes[i].getElementsByTagName("default")[0].childNodes[0].nodeValue + '"></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                else
                    outputmapping = '<tr id="outputmapping' + outputmappingNo + '"><td width="25%"><input name="taskOutputMappingid" type="hidden" id="taskOutputMappingid" value="' + outputmappingNo + '"><input name="textfield6" type="text" id="taskOutputMappingElementName' + outputmappingNo + '" value="' + outputNodes[i].getAttribute("id") + '"></td><td width="25%"><input name="textfield7" type="text" id="taskOutputMappingDisplayName' + outputmappingNo + '" value=""></td><td width="10%"><input name="textfield8" type="text" id="taskOutputMappingOrder' + outputmappingNo + '" value=""></td><td width="20%"><label><select id="taskOutputMappingType' + outputmappingNo + '" name="select3"><option value="string" selected>string</option><option value="int">int</option><option value="double">double</option><option value="float">float</option><option value="boolean">boolean</option><option value="organizationalEntity">organizationalEntity</option></select></label></td><td width="10%"><label><input name="textfield12" type="text" id="taskOutputMappingDefaultValues' + outputmappingNo + '" value=""></label></td><td><label><input type="button" class="outputDeleteButton btn btn-danger" name="outputDeleteButton' + outputmappingNo + '" id="outputDeleteButton' + outputmappingNo + '" value="Delete"></label></td></tr>';
                $("#" + taskDivName + " #outputmappingTable").append(
                    outputmapping);
                $('#' + taskDivName + ' #taskOutputMappingType' + mappingNo).val(outputNodes[i].getAttribute("type").replace("xsd:", ""));
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
                                            taskNode
                                                .getElementsByTagName("renderings")[0]
                                                .getElementsByTagName("outputs")[0]
                                                .removeChild(outputNodes[j]);
                                            break;
                                        }
                                        deleteNodeId++;
                                    }
                                }
                                makeDirty();
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
 //alert($('#' +taskDivName + ' #taskCallbackServiceName').val());
    // sync other fields
    if (taskNode.getElementsByTagName("documentation").length != 0) {
        $('#' + taskDivName + " #taskDocumentation")
            .val(
                taskNode.getElementsByTagName("documentation")[0].childNodes[0].nodeValue
                .trim());
    }
    if (taskNode.getElementsByTagName("priority").length != 0) {
        $('#' + taskDivName + " #taskPriority")
            .val(
                taskNode.getElementsByTagName("priority")[0].childNodes[0].nodeValue
                .trim());
    }
    if (taskNode.getElementsByTagName("interface").length != 0) {
        $('#' + taskDivName + " #taskOperation").val(
            taskNode.getElementsByTagName("interface")[0].getAttribute(
                "operation").trim());
    }
    // service URL mapping
    $('#' + taskDivName + " #taskCallbackOperationName").val(
        taskNode.getElementsByTagName("interface")[0].getAttribute(
            "responseOperation").trim());

    if (taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("name").length != 0) {
        $('#' + taskDivName + " #presentationElementDisplayName").val(
            taskNode.getElementsByTagName("presentationElements")[0]
            .getElementsByTagName("name")[0].childNodes[0].nodeValue
            .trim());
    }
    if (taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("subject").length != 0) {
        $('#' + taskDivName + " #presentationElementDisplaySubject").val(
            taskNode.getElementsByTagName("presentationElements")[0]
            .getElementsByTagName("subject")[0].childNodes[0].nodeValue
            .trim());
    }
    if (taskNode.getElementsByTagName("presentationElements")[0]
        .getElementsByTagName("description").length != 0) {
        $('#' + taskDivName + " #presentationElementDescription")
            .val(
                taskNode.getElementsByTagName("presentationElements")[0]
                .getElementsByTagName("description")[0].childNodes[0].nodeValue
                .trim());
    }
    // sync People assignments potential owners
    try {
        if (taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("potentialOwners").length != 0) {
            ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("potentialOwners")[0]
                .getElementsByTagName("argument")[0].getAttribute("name"));
            $('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "][value=potentialOwners" + ownerType + "]").prop("checked", true);
            if (ownerType != "Literal") {
                $('#' + taskDivName + " #potentialOwners" + ownerType)
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("potentialOwners")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            } else {
                $('#' + taskDivName + " #potentialOwnersLiteralUsers")
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("potentialOwners")[0]
                        .getElementsByTagName("users")[0].childNodes[0].nodeValue
                        .trim());
                        usersList = taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("potentialOwners")[0]
                        .getElementsByTagName("users");
                        for(var t=0;t<=usersList.length;t++){
                            
                        }

            }
        } else {
            $('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "][value=na]").prop("checked", true);
        }
        if (taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("businessAdministrators").length != 0) {
            ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("businessAdministrators")[0]
                .getElementsByTagName("argument")[0].getAttribute("name"));
            $('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "][value=businessAdministrators" + ownerType + "]").prop("checked", true);
            if (ownerType != "Literal") {
                $('#' + taskDivName + " #businessAdministrators" + ownerType)
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("businessAdministrators")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            } else {
                $('#' + taskDivName + " #businessAdministratorsLiteralUsers")
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("businessAdministrators")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            }
        } else {
            $('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "][value=na]").prop("checked", true);
        }
        if (taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("excludedOwners").length != 0) {
            ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("excludedOwners")[0]
                .getElementsByTagName("argument")[0].getAttribute("name"));
            $('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "][value=excludedOwners" + ownerType + "]").prop("checked", true);
            if (ownerType != "Literal") {
                $('#' + taskDivName + " #excludedOwners" + ownerType)
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("excludedOwners")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            } else {
                $('#' + taskDivName + " #excludedOwnersLiteralUsers")
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("excludedOwners")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            }
        } else {
            $('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "][value=na]").prop("checked", true);
        }
        if (taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("taskInitiator").length != 0) {
            ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("taskInitiator")[0]
                .getElementsByTagName("argument")[0].getAttribute("name"));
            $('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "][value=taskInitiator" + ownerType + "]").prop("checked", true);
            if (ownerType != "Literal") {
                $('#' + taskDivName + " #taskInitiator" + ownerType)
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("taskInitiator")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            } else {
                $('#' + taskDivName + " #taskInitiatorLiteralUsers")
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("taskInitiator")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            }
        } else {
            $('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "][value=na]").prop("checked", true);
        }
        if (taskNode.getElementsByTagName("peopleAssignments")[0]
            .getElementsByTagName("taskStakeholders").length != 0) {
            ownerType = toTitleCase(taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("taskStakeholders")[0]
                .getElementsByTagName("argument")[0].getAttribute("name"));
            $('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "][value=taskStakeholders" + ownerType + "]").prop("checked", true);
            if (ownerType != "Literal") {
                $('#' + taskDivName + " #taskStakeholders" + ownerType)
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("taskStakeholders")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            } else {
                $('#' + taskDivName + " #taskStakeholdersLiteralUsers")
                    .val(
                        taskNode.getElementsByTagName("peopleAssignments")[0]
                        .getElementsByTagName("taskStakeholders")[0]
                        .getElementsByTagName("argument")[0].childNodes[0].nodeValue
                        .trim());
            }
        } else {
            $('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "][value=na]").prop("checked", true);
        }
    } catch (err) {
        alert("People Assignments Couldnt be synced \nCaused by : " + err);
    }
    $('#' + taskDivName + ' .taskDiv').show();
    
    bindChangeEvents();
    try{
    wsdlRead = readCBWSDL(taskName);
    }catch (err) {
        alert("Error Reading WSDL");
    }
    if(typeof wsdlRead != 'undefined' || wsdlRead != 'undefined'){
        $('#' + taskDivName + ' #taskCallbackServiceURL').val(wsdlRead.getElementsByTagName("definitions")[0].getElementsByTagName("address")[0].getAttribute("location"));
        $('#' + taskDivName + ' #taskCallbackServiceName').val(wsdlRead.getElementsByTagName("definitions")[0].getElementsByTagName("service")[0].getAttribute("name"));
    }
    
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
    taskNode.getElementsByTagName("documentation")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskDocumentation").val();
    taskNode.getElementsByTagName("priority")[0].childNodes[0].nodeValue = $(
        '#' + taskDivName + " #taskPriority").val();
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
    taskNode.getElementsByTagName("interface")[0].setAttribute(
        "responseOperation", $(
            '#' + taskDivName + " #taskCallbackOperationName").val())
    taskNode.getElementsByTagName("interface")[0].setAttribute("portType", "cl:"+
        taskName + "PT");
    taskNode.getElementsByTagName("interface")[0].setAttribute(
            "responsePortType","cl:"+ taskName + "CBPT")
        // fill input mappings
    inputmappingNo = parseInt($('#' + taskDivName + " #taskMappingNo").val());
    inputNodes = taskNode.getElementsByTagName("renderings")[0]
        .getElementsByTagName("inputs")[0].childNodes;
    inputmapping = 0;
    for (i = 0; i < inputNodes.length; i++) {
        if (inputNodes[i].nodeName != '#text') {
            inputNodes[i].setAttribute("id", $(
                '#' + taskDivName + " #taskInputMappingElementName" + inputmapping).val());
            if (inputNodes[i].getElementsByTagName("label")[0].childNodes.length != 0)
                inputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskInputMappingDisplayName" + inputmapping).val();
            else
                addTextNode(inputNodes[i].getElementsByTagName("label")[0], xmlDom, $('#' + taskDivName + " #taskInputMappingDisplayName" + inputmapping).val());
            inputNodes[i].setAttribute("type", "xsd:" + $(
                '#' + taskDivName + " #taskInputMappingType" + inputmapping).val());
            if (inputNodes[i].getElementsByTagName("value")[0].childNodes.length != 0)
                inputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskInputMappingOrder" + inputmapping).val();
            else
                addTextNode(inputNodes[i].getElementsByTagName("value")[0], xmlDom, $('#' + taskDivName + " #taskInputMappingOrder" + inputmapping).val());
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
            if (outputNodes[i].getElementsByTagName("label")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagName("label")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingDisplayName" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagName("label")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingDisplayName" + outputmapping).val());
            outputNodes[i].setAttribute("type", "xsd:" + $(
                '#' + taskDivName + " #taskOutputMappingType" + outputmapping).val());
            if (outputNodes[i].getElementsByTagName("value")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagName("value")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingOrder" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagName("value")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingOrder" + outputmapping).val());

            if (outputNodes[i].getElementsByTagName("default")[0].childNodes.length != 0)
                outputNodes[i].getElementsByTagName("default")[0].childNodes[0].nodeValue = $(
                    '#' + taskDivName + " #taskOutputMappingDefaultValues" + outputmapping).val();
            else
                addTextNode(outputNodes[i].getElementsByTagName("default")[0], xmlDom, $('#' + taskDivName + " #taskOutputMappingDefaultValues" + outputmapping).val());

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
                    '#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked")
                .val()));
    else {
        if ($('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked").val() != "na") {
            addPeopleAssignementNode(taskNode, xmlDom, "potentialOwners");
            taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("potentialOwners")[0]
                .getElementsByTagName("argument")[0]
                .setAttribute(
                    "name",
                    getArgumentName($(
                            '#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked")
                        .val()));
        }
    }


    if ($('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked").val() == "potentialOwnersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #potentialOwnersRole").val();

    if ($('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked").val() == "potentialOwnersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #potentialOwnersExpression").val();

    if ($('#' + taskDivName + " input[name=potentialOwners" + taskDivName + "]:checked").val() == "potentialOwnersLiteral"){
        createNewLiteral(xmlDom,taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("potentialOwners")[0]
        .getElementsByTagName("from")[0],$('#' + taskDivName + " #potentialOwnersLiteralUsers").val(),"user");

    }
    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0]
        .setAttribute(
            "name",
            getArgumentName($(
                    '#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked")
                .val()));
    else {
        if ($('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked").val() != "na") {
            addPeopleAssignementNode(taskNode, xmlDom, "businessAdministrators");
            taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("businessAdministrators")[0]
                .getElementsByTagName("argument")[0]
                .setAttribute(
                    "name",
                    getArgumentName($(
                            '#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked")
                        .val()));

        }
    }

    if ($('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked")
        .val() == "businessAdministratorsRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #businessAdministratorsRole").val();
    
    if ($('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked")
        .val() == "businessAdministratorsExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #businessAdministratorsExpression").val();

    if ($('#' + taskDivName + " input[name=businessAdministrators" + taskDivName + "]:checked")
        .val() == "businessAdministratorsLiteral")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("businessAdministrators")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #businessAdministratorsLiteralUsers").val();


    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0]
        .setAttribute("name", getArgumentName($(
            '#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val()));
    else {
        if ($('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val() != "na") {
            addPeopleAssignementNode(taskNode, xmlDom, "excludedOwners");
            taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("excludedOwners")[0]
                .getElementsByTagName("argument")[0]
                .setAttribute("name", getArgumentName($(
                    '#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val()));
        }
    }
    if ($('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val() == "excludedOwnersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #excludedOwnersRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val() == "excludedOwnersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #excludedOwnersExpression").val();

    if ($('#' + taskDivName + " input[name=excludedOwners" + taskDivName + "]:checked").val() == "excludedOwnersLiteral")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("excludedOwners")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #excludedOwnersLiteralUsers").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].setAttribute("name",
            getArgumentName($(
                '#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val()));
    else {
        if ($('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val() != "na") {
            addPeopleAssignementNode(taskNode, xmlDom, "taskInitiator");
            taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("taskInitiator")[0]
                .getElementsByTagName("argument")[0].setAttribute("name",
                    getArgumentName($(
                        '#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val()));
        }
    }
    if ($('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val() == "taskInitiatorRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskInitiatorRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val() == "taskInitiatorExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskInitiatorExpression").val();

    if ($('#' + taskDivName + " input[name=taskInitiator" + taskDivName + "]:checked").val() == "taskInitiatorLiteral")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskInitiator")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskInitiatorLiteralUsers").val();

    if (taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders").length != 0)
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].setAttribute("name",
            getArgumentName($(
                    '#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked")
                .val()));
    else {
        if ($('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked").val() != "na") {
            addPeopleAssignementNode(taskNode, xmlDom, "taskStakeholders");
            taskNode.getElementsByTagName("peopleAssignments")[0]
                .getElementsByTagName("taskStakeholders")[0]
                .getElementsByTagName("argument")[0].setAttribute("name",
                    getArgumentName($(
                            '#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked")
                        .val()));
        }
    }
    if ($('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked").val() == "taskStakeholdersRole")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskStakeholdersRole").val();
    // Set Literal Values
    if ($('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked").val() == "taskStakeholdersExpression")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskStakeholdersExpression").val();

    if ($('#' + taskDivName + " input[name=taskStakeholders" + taskDivName + "]:checked").val() == "taskStakeholdersLiteral")
        taskNode.getElementsByTagName("peopleAssignments")[0]
        .getElementsByTagName("taskStakeholders")[0]
        .getElementsByTagName("argument")[0].childNodes[0].nodeValue = $(
            '#' + taskDivName + " #taskStakeholdersLiteralUsers").val();

    var peopleAssignmentsList = taskNode.getElementsByTagName("peopleAssignments")[0].childNodes;
    for (i = 0; i < peopleAssignmentsList.length; i++) {
        if (peopleAssignmentsList[i].nodeName != "#text") {
            if (peopleAssignmentsList[i].getElementsByTagName("argument")[0].getAttribute("name") == "None") {
                taskNode.getElementsByTagName("peopleAssignments")[0].removeChild(peopleAssignmentsList[i]);
            }
        }
    }

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
        return "None";
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
        alert("Marshalling Error"+err);
    }
    return root;
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
        newFrom.setAttribute("logicalPeopleGroup", "regionalClerks");
        newArgumentText = xmlDom.createTextNode("regionalClerksRole");
        newArgument.appendChild(newArgumentText);
        newFrom.appendChild(newArgument);
        newAssignmentNode.appendChild(newFrom);
        taskNode.getElementsByTagName("peopleAssignments")[0].appendChild(newAssignmentNode);
    } catch (err) {
        alert(err);
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


$('.sectionHeader').click(function() {
    $(this).parent().find('.taskSection').slideToggle(500);

});

function bindChangeEvents() {

   $('input').keyup(function() {
        makeDirty();
        //generateText();
    });

    $('textarea').keyup(function() {
        makeDirty();
        //generateTasks();
    });

    $('select').change(function() {
        makeDirty();
        //generateTasks();
    });

 }

 function createNewLiteral(xmlDom,parent,text,type){
    var splitList = text.split(",");
    newLiteral = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803",
    "htd:literal"); // scheme.appendchild()
    newOrgEntity = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
    "htt:organizationalEntity");
    for(var i=0;i<=splitList.length;i++){
        if(type=="user"){
        newUser = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
        "htt:user");
        newUserText = xmlDom.createTextNode(splitList[i]);
        newUser.appendChild(newUserText);
        newLiteral.appendChild(newUser);
        }else if(type=="group"){
        newGroup = xmlDom.createElementNS("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
        "htt:group");
        newGroupText = xmlDom.createTextNode(splitList[i]);
        newGroup.appendChild(newGroupText);
        newLiteral.appendChild(newGroup);    
        }
    }
    newLiteral.appendChild(newOrgEntity);
    parent.appendChild(newLiteral);
        
 }

function removeUnwantedArtifacts(){
    var taskNames = ["removeWSDL"];
    tasksList = xmlDom.getElementsByTagName("task");
    nodes = Array.prototype.slice.call(tasksList, 0);
    nodes.forEach(function(taskNode) {
        taskNames.push(taskNode.getAttribute("name"));
    });
   
    ExecuteCustomFunction.apply(this,taskNames);
}