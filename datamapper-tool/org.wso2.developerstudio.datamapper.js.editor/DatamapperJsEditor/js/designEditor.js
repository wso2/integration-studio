//try to get the canvas inside the switch mediator item!!! :( :P Awanthikooo
function selectDeleteFunction() {
    if (CurElement != null) {
        CurElement.removeClass('selected'); //deselect old
    }

    CurElement = $(this);
    id = $(this).attr('id');
    CurElement.addClass('selected'); //select new
}


function designViewKeyDown(e) {

    //alert(e.which); //run to find the keycode of the key you want, don't use backspace, that is used to go back in browser history
    if (e.keyCode == 46 && CurElement != null) {
        var connectionList = jsPlumb.getAllConnections();
        for (var connection in connectionList) {
            if (connectionList.hasOwnProperty(connection)) {
                if (connectionList[connection].sourceId == CurElement.attr('id')) {
                    CurElementisSource = connectionList[connection].targetId
                }
                if (connectionList[connection].targetId == CurElement.attr('id')) {
                    CurElementisTarget = connectionList[connection].sourceId
                }
            }
        }

        if (CurElement.attr('id') == lastItem.attr('id')) {
            lastItem = $("#" + CurElementisTarget);
            //y = y - 100;
        }
        jsPlumb.detachAllConnections(id);
        CurElement.remove();


        if (CurElementisTarget != null && CurElementisSource != null) {
            connectDivs(CurElementisTarget, CurElementisSource);
            CurElementisSource = null;
            CurElementisTarget = null;
        }

        CurElement = null; //clear, that element doesn't exist anymore
    }
}


function createDiv(objName, image, type, topLoc) {
	
	var m1 = new joint.shapes.devs.Model({
	    position: { x: 50, y: 50 },
	    size: { width: 90, height: 90 },
	    inPorts: ['in1','in2'],
	    outPorts: ['out'],
	    attrs: {
	        '.label': { text: 'Model', 'ref-x': .4, 'ref-y': .2 },
	        rect: { fill: '#2ECC71' },
	        '.inPorts circle': { fill: '#16A085' },
	        '.outPorts circle': { fill: '#E74C3C' }
	    }
	});
	graph.addCell(m1);
	
//    var xLoc = CurXLoc - 400;
//    var element = $("<div></div>");
//
//    element.click(selectDeleteFunction);
//    element.dblclick(openPopupDialog);
//    setData(element, type);
//
//
//    if (type == "SwitchMediator") {
//        addSwitchMediator(element, objName, xLoc, image);
//    } else {
//        element.attr('id', objName);
//        element.append(image);
//        $("#jsPlumbContainer").append(element);
//        jsPlumb.draggable(objName, {
//            containment: $("#jsPlumbContainer")
//        });
//        element.css({'top': topLoc, 'left': xLoc});
//        element.addClass("wso2Mediator_style");
//    }
}


//add div functoin
function AddDiv(logMediatorObj) {
	
	jsonStr = '{"log":' + JSON.stringify(logMediatorObj) + ' }'
    jsonObj1 = $.parseJSON(jsonStr);

    editorItemCounter++;
    var newElemCreated = "draggedElem" + editorItemCounter;
    console.log('Adding a log mediator' + newElemCreated + '  ' + jsonStr);
    console.log(jsonObj1);
    var element = $("<div></div>");
    element.css({'top': x, 'left': 250 + xSpace});
    element.attr('id', newElemCreated);
    element.addClass("draggable");
    element.prepend('<img src="icons/log-mediator.gif" />')
    element.click(selectDeleteFunction);
    element.dblclick(openPopupDialog);
    element.data('jsonConfig', jsonObj1);
    element.addClass("wso2Mediator_style");
    $("#jsPlumbContainer").append(element);
    lastItem = $("#" + newElemCreated);
    xSpace += 200;
    return newElemCreated;
}


function addSwitchMediator(element, objName, leftLoc, image) {

    $("#jsPlumbContainer").append('<div id=' + objName + ' style="height: 165px; width: ' + divwidth + 'px; background: #fff0f0;"></div>')
    $("#" + objName).append('<div id="jsPlumbContainer1" style=" height:100%; width:100%;"></div>')
    $("#jsPlumbContainer1").append('<table id="switchtableID" width="100%" height="100%"><table/>');
    $("#switchtableID").append('<tr><td  id="draggedSwitchMediatorin" rowspan="2" style="switchTableLeftTDStyle">Switch Mediator</td><td style="switchTableTDStyle"><div id="jsPlumbContainerWrapper11" class="well-lg"  style="height:100%; width:100%; background: #ffffff;">Case</div></td></tr>');
    $("#switchtableID").append('<tr><td style="switchTableTDStyle"><div id="jsPlumbContainerWrapper12" class="well-lg"  style="height:100%; width:100%; background: #ffffff;">Default</div></td></tr>');
    $("#draggedSwitchMediatorin").append(image);
    element.attr('id', objName + "inside");
    $("#" + objName).addClass("wso2Mediator_style");
    $("#" + objName).draggable()
    $("#draggedSwitchMediatorin").append(element);
    $("#" + objName + "inside").position({
        my: "left center",
        at: "left center",
        of: "#draggedSwitchMediatorin"
    });

    //$("#jsPlumbContainerWrapper12").append(element);
    $("#" + objName).css({'top': topLoc, 'left': leftLoc});
}


//connect function
function connectDivs(source, target) {
    console.log('connectDivs ' + source + '   ' + target);
    jsPlumb.connect({
        source: source,
        target: target,
        anchors: ["Right", "Left" ],
        paintStyle: { strokeStyle: "#3366FF", lineWidth: 1 },
        connector: ["Flowchart", { curviness: 100}],
        connectorStyle: [
            { lineWidth: 1, strokeStyle: "#3366FF" }
        ],
        hoverPaintStyle: { strokeStyle: "#3366FF", lineWidth: 8 }
    });
}


function jsplumbHandleDraggable() {
    $(".draggableIcon").draggable({
        helper: 'clone',
        containment: 'jsPlumbContainer',
        cursor: 'move',
        zIndex: 1000,
        //When first dragged
        stop: function (ev, ui) {

        }
    });
}


function jsplumbHandleDropable() {

    var newDraggedElem = null;
    var newDroppedElem = null;
    var newDroppedItem = null;

    $("#jsPlumbContainer").droppable({
        drop: function (ev, ui) {//to locate the element
            var yLoc = CurXLoc - 400; //to get the current location in the div
            var currentConnectionList = jsPlumb.getAllConnections();
            for (var connection in currentConnectionList) {//getting a map of the existing elements in the canvas
                if (currentConnectionList.hasOwnProperty(connection)) {
                    elemSourceId[connection] = currentConnectionList[connection].sourceId;
                    elemSource = document.getElementById(elemSourceId[connection]);
                    elemSourceLocList[connection] = elemSource.offsetLeft;

                    elemTargetId[connection] = currentConnectionList[connection].targetId;
                    elemTarget = document.getElementById(elemTargetId[connection]);
                    elemTargetLocList[connection] = elemTarget.offsetLeft;
                }
            }
            if ($(ui.draggable).attr('id').search(/dragged/) == -1) {
                editorItemCounter++;
                var newDraggedElem = $(ui.draggable).clone();
                newDraggedElem.removeClass("draggableIcon");
                newDraggedElem.removeClass("ui-draggable");
                var type = newDraggedElem.attr('id');

                if (over == "false") {

                    //getting the switch mediator background stuff created

                    newDroppedElem = "dragged" + type + editorItemCounter;
                    createDiv(newDroppedElem, newDraggedElem, type, 170);

                    for (var elemInList in elemSourceLocList) {
                        if (elemSourceLocList.hasOwnProperty(elemInList)) {
                            if (yLoc > elemSourceLocList[elemInList] && yLoc < elemTargetLocList[elemInList]) {
                                jsPlumb.detach(currentConnectionList[elemInList]);
                                elemIsMiddle = true;
                                connectDivs(elemSourceId[elemInList], $("#" + newDroppedElem));
                                connectDivs($("#" + newDroppedElem), elemTargetId[elemInList]);
                            }
                        }
                    }
                    newDroppedItem = $("#" + newDroppedElem);
                    if (elemIsMiddle != true) {
                        if (lastItem == null) {
                            if (type == "SwitchMediator") {
                                lastItem = newDroppedItem;
                            } else {
                                lastItem = newDroppedItem;
                            }
                        } else {
                            connectDivs(lastItem, newDroppedItem);
                        }
                        if (type != "SwitchMediator") {
                            lastItem = newDroppedItem;
                        } else {
                            lastItem = newDroppedItem;
                        }
                    }

                } else {//to locate the element
                    newElemXLoc += 80;

                    $("#draggedSwitchMediator1").css("width", divwidth + newElemXLoc + "px"); // naming is done dynamically, since we are working with only one switch mediator it is named as this
                    $("#jsPlumbContainer1").css("width", divwidth + newElemXLoc + "px");
                    $("#draggedSwitchMediator1").css("height", "300px");
                    $("#draggedSwitchMediator1").css("width", "80px");
                        //getting the switch mediator background stuff created
                        if (type == "SwitchMediator") {
                            $('jsPlumbContainerWrapper1').show();
                        }
                        newDroppedElem = "dragged" + type + "switch" + editorItemCounter;

                        createDiv(newDroppedElem, newDraggedElem, type, topLocation);
                        //trying to get from the map
                        for (var eleminList in elemSourceLocList) {

                            if (elemSourceLocList.hasOwnProperty(eleminList)) {

                                if (yLoc > elemSourceLocListIn[eleminList] && yLoc < elemTargetLocListIn[eleminList]) {
                                    jsPlumb.detach(currentConnectionList1[eleminList]);
                                    elemIsMiddle = true;
                                    connectDivs(elemSourceId1[eleminList], $("#" + newDroppedElem));
                                    connectDivs($("#" + newDroppedElem), elemTargetId1[eleminList]);
                                }
                            }
                        }
                    newDroppedItem = $("#" + newDroppedElem)
                        if (elemIsMiddle != true) {
                            if (lastItemInSwitch == null) {
                                lastItemInSwitch = newDroppedItem;
                            } else {
                                connectDivs(lastItemInSwitch, newDroppedItem);
                            }
                            lastItemInSwitch = newDroppedItem;
                        }
                    }
                }
        },
        tolerance: "pointer"
    });

}

