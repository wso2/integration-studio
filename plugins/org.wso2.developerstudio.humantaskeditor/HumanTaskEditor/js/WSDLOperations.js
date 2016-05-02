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


/*
 * Signature: saveWSDL(inputWsdl, fileName) {...}
 * 
 * This method saves generated wsdl dom with the modifications done in
 * generateWSDL methods into the WSDL file created. A WSDL dom(inputWSDL) and a
 * file name(fileName) should be provided as the parameters
 * 
 * 
 */
var hicNameSpace = "http://wso2.org/ht/schema/deployment/config";
var xsdNameSpace = "http://www.w3.org/2001/XMLSchema";
var wsdlNameSpace = "http://schemas.xmlsoap.org/wsdl/";
var soapNameSpace = "http://schemas.xmlsoap.org/wsdl/soap/";

function saveWSDL(inputWsdl, fileName) {
    // Read contents of the file.
    wsdlContent = new XMLSerializer().serializeToString((inputWsdl));
    try {
        IDESaveContentWithExtention(wsdlContent, "", fileName, "wsdl");
    } catch (err) {
        alert(err);
    }
}

function saveHTConfig(inputWsdl) {
    // Read contents of the file.
    htconfigContent = new XMLSerializer().serializeToString((inputWsdl));
    try {
        IDESaveContentWithExtention(htconfigContent, "", "htconfig", "xml");
    } catch (err) {
        alert(err);
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
    wsdlHTDeploymentConfig = configDom.getElementsByTagName("HTDeploymentConfig")[0];

    tasksList = xmlDom.getElementsByTagName("task");
    for(l=0;l<tasksList.length;l++){

        var taskName = tasksList[l].getAttribute("name");
        var divTaskName = taskName + "wrapper";
        newTask = configDom.createElementNS(hicNameSpace,
            "hic:task"); // scheme.appendchild()
        newTask.setAttribute("name", "claimtask:"+taskName);
        newPublish = configDom.createElementNS(hicNameSpace,
            "hic:publish");
        newPublishService = configDom.createElementNS(hicNameSpace,
            "hic:service");
        newPublishService.setAttribute("name","claim:"+taskName+"Service");
        newPublishService.setAttribute("port",taskName + "Port"); 
        newPublish.appendChild(newPublishService);
        newCallback = configDom.createElementNS(hicNameSpace,
            "hic:callback");
        newCallbackService = configDom.createElementNS(hicNameSpace,
            "hic:service");
        newCallbackService.setAttribute("name","claim:"+$('#' + divTaskName + ' #taskCallbackServiceName').val());
        newCallbackService.setAttribute("port",taskName + "CBPort"); 
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
function generateInputWSDL(wsdlDom, currentTask) {
    currentTaskName = currentTask + "wrapper";
    // Get internal parameters
    serviceURL = "http://localhost:9763/services/"+currentTask+"Service";
    operationName = $('#' + currentTaskName + ' #taskOperation')
        .val();
    serviceName = currentTask+"Service";
    portName = currentTask + "Port";
    inputElements = $('#' + currentTaskName + ' #inputmappingTable tr');

    // get Definitions node and Schema node from dummy wsdl dom
    wsdlSchema = wsdlDom.getElementsByTagName("schema")[0];
    wsdlDefinitions = wsdlDom.getElementsByTagName("definitions")[0];
    //alert("Inside generate Input "+currentTask+" : "+ $('#' + currentTask + 'wrapper #taskCallbackServiceName').val());
    // create Data type elements
    newComplexType = wsdlDom.createElementNS(
        xsdNameSpace, "xsd:complexType");
    newComplexType.setAttribute("name", currentTask + "DataType"); // Data type
    // Name
    newSequence = wsdlDom.createElementNS(xsdNameSpace,
        "xsd:sequence");

    // Loop towards the rows of input data mapping table
    inputElements.each(function(i, obj) {
        if (i != 0) { // skip header
            k = $(this).find("input#taskInputMappingid").val();
            type = "xsd:" + $("#" + currentTaskName + " #taskInputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                xsdNameSpace, "xsd:element");
            newSubElement.setAttribute("name", $(this).find(
                "input#taskInputMappingElementName" + k).val()); // Data
            newSubElement.setAttribute("type", type); // Data element (Input
            newSequence.appendChild(newSubElement);
        }
    });
    newComplexType.appendChild(newSequence);

    // create Element element
    newElement = wsdlDom.createElementNS(xsdNameSpace,
        "xsd:element"); // scheme.appendchild()
    newElement.setAttribute("name", currentTask + "Data");
    newElement.setAttribute("type", "tns:" + currentTask + "DataType");
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);

    // create Message element
    newMessage = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:message");
    newMessage.setAttribute("name", currentTask + "Request");
    newPart = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:part");
    newPart.setAttribute("name", newMessage.getAttribute("name"));
    newPart.setAttribute("element", "tschema:" + newElement.getAttribute("name")); // Data binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);

    // create portType element
    newPortType = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:portType");
    newPortType.setAttribute("name", currentTask + "PT"); // Interface Port
    // Type
    newOperation = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:operation");
    newOperation.setAttribute("name", operationName); // Interface Operation
    newInput = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:input");
    newInput.setAttribute("message","tns:"+ newMessage.getAttribute("name")); // message
    // binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);

    // create Binding element
    newBinding = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:binding");
    newBinding.setAttribute("name", currentTask + "Binding"); // Data element
    // name
    newBinding.setAttribute("type", "tns:" + newPortType.getAttribute("name")); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        soapNameSpace, "soap:binding");
    newSoapBinding.setAttribute("style", "document"); // part element
    newSoapBinding.setAttribute("transport",
        "http://schemas.xmlsoap.org/soap/http"); // tns:complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        wsdlNameSpace, "wsdl:operation");
    newWSDLBindingOperation.setAttribute("name", operationName); // Operation
    // Name
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        soapNameSpace, "soap:operation");
    newWSDLBindingSoapOperation.setAttribute("soapAction", "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute("style", "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        wsdlNameSpace, "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        soapNameSpace, "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);

    // create service element
    newService = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:service");
    newService.setAttribute("name", serviceName); // Data element name
    newPort = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:port");
    newPort.setAttribute("name", portName); // part element
    newPort.setAttribute("binding","tns:" + newBinding.getAttribute("name")); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        soapNameSpace, "soap:address");
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
function generateOutputWSDL(wsdlDom, currentTask,serviceURL,operationName,serviceName,outputElements) {
    currentTaskName = currentTask + "wrapper";
    /*serviceURL = $('#' + currentTaskName + ' #taskCallbackServiceURL').val();
    operationName = $('#' + currentTaskName + ' #taskCallbackOperationName')
        .val();
    serviceName = $('#' + currentTaskName + ' #taskCallbackServiceName').val();

    
    outputElements = $('#' + currentTaskName + ' #outputmappingTable tr');*/
    portName = currentTask + "CBPort";
    // get Definitions
    wsdlSchema = wsdlDom.getElementsByTagName("schema")[0];
    wsdlDefinitions = wsdlDom.getElementsByTagName("definitions")[0];
    // create types(data)
    newComplexType = wsdlDom.createElementNS(
        xsdNameSpace, "xsd:complexType");
    newComplexType.setAttribute("name", currentTask + "CBDataType"); // Data
    // type
    // Name
    newSequence = wsdlDom.createElementNS(xsdNameSpace,
        "xsd:sequence");
    // should loop for input types
    outputElements.each(function(i, obj) {
        if (i != 0) {
            k = $(this).find("input#taskOutputMappingid").val();
            type = "xsd:" + $("#" + currentTaskName + " #taskOutputMappingType" + k)
                .val();
            newSubElement = wsdlDom.createElementNS(
                xsdNameSpace, "xsd:element");
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
    newElement = wsdlDom.createElementNS(xsdNameSpace,
        "xsd:element"); // scheme.appendchild()
    newElement.setAttribute("name", currentTask + "CBData"); // part element
    newElement.setAttribute("type", "tns:" + currentTask + "CBDataType"); // tns:
    // complextypename
    wsdlSchema.appendChild(newElement);
    wsdlSchema.appendChild(newComplexType);
    // create message
    newMessage = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:message");
    newMessage.setAttribute("name", currentTask + "CBRequest");
    newPart = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:part");
    newPart.setAttribute("name", newMessage.getAttribute("name")); // ClaimApprovalRequest
    newPart.setAttribute("element", "tschema:" + newElement.getAttribute("name")); // Data
    // binding
    newMessage.appendChild(newPart);
    wsdlDefinitions.appendChild(newMessage);
    // create portType
    newPortType = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:portType");
    newPortType.setAttribute("name", currentTask + "CBPT"); // Interface Port
    // Type
    newOperation = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:operation");
    newOperation.setAttribute("name", operationName); // Interface Operation
    newInput = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:input");
    newInput.setAttribute("message", "tns"+newMessage.getAttribute("name")); // message
    // binding
    newOperation.appendChild(newInput);
    newPortType.appendChild(newOperation);
    wsdlDefinitions.appendChild(newPortType);
    // {create service element}
    newBinding = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:binding");
    newBinding.setAttribute("name", currentTask + "CBBinding"); // Data element
    // name
    newBinding.setAttribute("type", "tns:" + newPortType.getAttribute("name")); // PortTypeName
    newSoapBinding = wsdlDom.createElementNS(
        soapNameSpace, "soap:binding");
    newSoapBinding.setAttribute("style", "document"); // part element
    newSoapBinding.setAttribute("transport",
        "http://schemas.xmlsoap.org/soap/http"); // tns: complextypename
    newWSDLBindingOperation = wsdlDom.createElementNS(
        wsdlNameSpace, "wsdl:operation");
    newWSDLBindingOperation.setAttribute("name", operationName); // Operation
    // Name'
    newWSDLBindingSoapOperation = wsdlDom.createElementNS(
        soapNameSpace, "soap:operation");
    newWSDLBindingSoapOperation.setAttribute("soapAction", "urn:" + operationName);
    newWSDLBindingSoapOperation.setAttribute("style", "document");
    newWSDLBindingInput = wsdlDom.createElementNS(
        wsdlNameSpace, "wsdl:input");
    newSoapInputBody = wsdlDom.createElementNS(
        soapNameSpace, "soap:body");
    newSoapInputBody.setAttribute("use", "literal");
    newWSDLBindingInput.appendChild(newSoapInputBody);
    newWSDLBindingOperation.appendChild(newWSDLBindingSoapOperation);
    newWSDLBindingOperation.appendChild(newWSDLBindingInput);
    newBinding.appendChild(newSoapBinding);
    newBinding.appendChild(newWSDLBindingOperation);
    wsdlDefinitions.appendChild(newBinding);
    // {create binding}
    newService = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:service");
    newService.setAttribute("name", serviceName); // Data element name
    newPort = wsdlDom.createElementNS(wsdlNameSpace,
        "wsdl:port");
    newPort.setAttribute("name", portName); // part element
    newPort.setAttribute("binding","tns:"+ newBinding.getAttribute("name")); // tns:complextypename
    newAddress = wsdlDom.createElementNS(
        soapNameSpace, "soap:address");
    newAddress.setAttribute("location", serviceURL); // Service URL
    newPort.appendChild(newAddress);
    newService.appendChild(newPort);
    wsdlDefinitions.appendChild(newService);

}
