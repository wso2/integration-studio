var graph = null;
var paper = null;
var mInput = null;
var mOutput= null;
var zoomHandler = null;
var operatorSize = {width : 90,	height : 90};

//TODO try module design pattern
$(document).ready(function () {
    registerTabChangeEvent();
    initDraggable();
    initDropable();
    initJointJSGraph();
    registerMouseAndKeyEvents();
    zoomHandler = new ZoomHandler(paper);
});


function registerMouseAndKeyEvents() {
	$(document).mouseup(function (e) {
		zoomHandler.updateLastMouseCoords(e);
	});
	
	paper.on('blank:pointerdown', function(e, x, y) { 
		zoomHandler.setStartMouseCoords(e);
	});

	$(document).mousedown(function (e) {
		
	});
  
	$(document).mouseenter(function (e) {
	
	});

    $(document).mouseleave(function (e) {

    });

    $(document).mousemove(function (e) { 
    	zoomHandler.changeCenter(e);
    });
    
    $(document).bind('mousewheel', function(e) {
    	zoomHandler.changeZoom(e, $(this).offset());
    });

    $(document).keydown(function (e) {  	
    	if(e.keyCode==46){//delete key pressed
    	   		if (selected) selected.remove();
    	}
    });
}


function registerTabChangeEvent() {
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        console.log('tabChagne');
        var tabName = $(e.target).html();
        if (tabName == 'Source') {
            activateSourceView();
        } else {
            activateDesignView();
        }
    });
}

function activateSourceView() {
    console.log('activateSourceView');
    var sourceEditorTBox = $('#sourceEditorTextBox');
    var sourceScript = generateLanguage();
    sourceEditorTBox.val(sourceScript);
}


function activateDesignView() {
	console.log('activateDesignView');
    var sourceEditorTextBox = $('#sourceEditorTextBox');
}

function initDraggable() {
	$(".draggableIcon").draggable({
		helper : 'clone',
		containment : 'dmEditorContainer',
		cursor : 'move',
		stop : handleDragStopEvent
	});
}

function initDropable() {
	$("#dmEditorContainer").droppable({
		drop : handleDropEvent,
		tolerance : "pointer"
	});
}

function handleDragStopEvent(event, ui) {

}

function handleDropEvent(event, ui) {
	if ($(ui.draggable).attr('id').search(/dragged/) == -1) {
		var newDraggedElem = $(ui.draggable).clone();
		var type = newDraggedElem.attr('id');
		var position = {}
		position.x  = ui.offset.left - $(this).offset().left;
		position.y   = ui.offset.top - $(this).offset().top;
		var paperPoint = paper.clientToLocalPoint(position);
		createDiv(type, paperPoint, type);
	}
}

function createDiv(objName, position, type) {
	var operator = null;
	if (objName=="Concat"){
		operator = new joint.shapes.devs.Model({
			size : operatorSize,
			position : position,
			inPorts : [ 'in1', 'in2' ],
			outPorts : [ 'out' ],
			attrs : {
				'.label' : {
					text : objName,
					'ref-x' : .4,
					'ref-y' : .2
				},
				'graphProperties': {
					marked : 0,
					visited: 0,
					index : -1,
					portVariableIndex:[-1]
		        },
		        rect : { fill: '#F0F0F0', rx: 8, ry: 8, 'stroke-width': 2, stroke: 'blue' },
				circle: { r: 6 },
				'.inPorts circle' : {
					fill : '#6495ED'
				},
				'.outPorts circle' : {
					fill : '#6495ED'
				}
			}
		});
    } else if (objName=="Split") {
    	operator = new joint.shapes.devs.Model({
			size : operatorSize,
			position : position,
			inPorts : [ 'in1' ],
			outPorts : [ 'out1' , 'out2'],
			attrs : {
				'.label' : {
					text : objName,
					'ref-x' : .4,
					'ref-y' : .2
				},
				'graphProperties': {
							marked : 0,
							visited: 0,
							index : -1,
							portVariableIndex:[-1,-1]
				},
				rect : { fill: '#F0F0F0', rx: 8, ry: 8, 'stroke-width': 2, stroke: 'blue' },
				circle: { r: 6},
				'.inPorts circle' : {
					fill : '#6495ED'
				},
				'.outPorts circle' : {
					fill : '#6495ED'
				}
			}
		});
    }
	
	graph.addCell(operator);
}


function openInputDialog() {
	$('#myInput').bind("change", handleInputFileSelect);
	$('#myInput').click();
}

function openOutputDialog() {
	$('#myOutput').bind("change", handleOutputFileSelect);
	$('#myOutput').click();
}

function Undo() {
	undoRedoHandler.undo(); 
}

function Redo() {
	undoRedoHandler.redo();
}


function handleFileSelect(evt, box, isOutput) {
	var f = evt.target.files[0]; 
    if (f) {
	      var reader = new FileReader();
	      reader.readAsText(f);
	      reader.onload = function(e) { 
		      var contents = e.target.result;
		      console.log(contents);
		  	  var obj = JSON.parse(contents);
			  traverseObject(obj, 1, box, isOutput);
			  relocateElement(box);
			  undoRedoHandler.reset();
	      }
    } else { 
    	  alert("Failed to load file");
    }
}

function handleInputFileSelect(evt) {
	var firstChild = mInput.getEmbeddedCells()[0];
	if (firstChild) {
		firstChild.remove();
	}
    handleFileSelect(evt, mInput, true);
}

function handleOutputFileSelect(evt) {
	var firstChild = mOutput.getEmbeddedCells()[0];
	if (firstChild) {
		firstChild.remove();
	}
    handleFileSelect(evt, mOutput, false);
}

