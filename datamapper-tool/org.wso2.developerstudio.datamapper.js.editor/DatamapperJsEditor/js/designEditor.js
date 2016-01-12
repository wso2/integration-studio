

function initDraggable() {
    $(".draggableIcon").draggable({
        helper: 'clone',
        containment: 'dmEditorContainer',
        cursor: 'move',
        stop: handleDragStopEvent
    });
}

function initDropable() {
    $("#dmEditorContainer").droppable({
        drop: handleDropEvent,
        tolerance: "pointer"
    });
}

function initJointJSGraph() {
    graph = new joint.dia.Graph;

    paper = new joint.dia.Paper({
        el: $('#dmEditorContainer'),
        width: 1200,
        model: graph,
        gridSize: 1
    });
    
    paper.on('cell:pointerdown', function(cellView) {
        selected = cellView.model;
        console.log("selected = " + selected);
    });
    
    var mInput = new joint.shapes.devs.Model({
    	id:'inputBox',
	    position: { x: 50, y: 50 },
	    size: { width: 150, height: 400 },
	    outPorts: ['out'],
	    attrs: {
	        '.label': { text: 'Input Type', 'ref-x': .4, 'ref-y': .2 },
	        rect: { fill: 'gray' },
	        '.outPorts circle': { fill: '#E74C3C' }
	    }
	});

	var mOutput = new joint.shapes.devs.Model({
    	id:'outputBox',
	    position: { x: 1050, y: 50 },
	    size: { width: 150, height: 400 },
	    inPorts: ['in'],
	    attrs: {
	        '.label': { text: 'Output Type', 'ref-x': .4, 'ref-y': .2 },
	        rect: { fill: 'gray' },
	        '.inPorts circle': { fill: '#E74C3C' }
	    }
	});
	
	graph.addCell(mInput);
	graph.addCell(mOutput);
	
    //graph.fromJSON(JSON.parse('{"cells":[{"type":"basic.Rect","position":{"x":100,"y":30},"size":{"width":100,"height":30},"angle":0,"id":"4713e533-6d0f-48e3-8098-2fee3364d023","z":1,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"basic.Rect","position":{"x":238,"y":107},"size":{"width":100,"height":30},"angle":0,"id":"426e4cea-bb7e-46db-b6a2-75331764385b","embeds":"","z":2,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"link","source":{"id":"4713e533-6d0f-48e3-8098-2fee3364d023"},"target":{"id":"426e4cea-bb7e-46db-b6a2-75331764385b"},"id":"e32c2313-2f15-477d-804d-fd1c327b5944","z":3,"attrs":{}}]}'));

}


function handleDragStopEvent( event, ui ) {
	
}

function handleDropEvent( event, ui ) {
	 if ($(ui.draggable).attr('id').search(/dragged/) == -1) {
         var newDraggedElem = $(ui.draggable).clone();
         newDraggedElem.removeClass("draggableIcon");
         newDraggedElem.removeClass("ui-draggable");
         var type = newDraggedElem.attr('id');
         createDiv("Concat", newDraggedElem, type);
     }
}

function createDiv(objName, image, type) {
	
	var m1 = new joint.shapes.devs.Model({
	    position: { x: 50, y: 50 },
	    size: { width: 90, height: 90 },
	    inPorts: ['in1','in2'],
	    outPorts: ['out'],
	    attrs: {
	        '.label': { text: objName, 'ref-x': .4, 'ref-y': .2 },
	        rect: { fill: '#2ECC71' },
	        '.inPorts circle': { fill: '#16A085' },
	        '.outPorts circle': { fill: '#E74C3C' }
	    }
	});
	graph.addCell(m1);
}


