

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

            if ($(ui.draggable).attr('id').search(/dragged/) == -1) {
                editorItemCounter++;
                var newDraggedElem = $(ui.draggable).clone();
                newDraggedElem.removeClass("draggableIcon");
                newDraggedElem.removeClass("ui-draggable");
                var type = newDraggedElem.attr('id');

                if (over == "false") {
                    newDroppedElem = "dragged" + type + editorItemCounter;
                    createDiv(newDroppedElem, newDraggedElem, type, 170);
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
                    }
                }
        },
        tolerance: "pointer"
    });

}

