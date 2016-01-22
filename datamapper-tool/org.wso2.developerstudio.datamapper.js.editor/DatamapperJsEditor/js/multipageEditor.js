var graph = null;
var paper = null;
var mInput = null;
var mOutput = null;
var zoomHandler = null;
var undoRedoHandler = null;
var operatorFactory = null;
var inputSchema = null;
var outputSchema = null;
var menu1;

//TODO try module design pattern
$(document).ready(function() {
	registerTabChangeEvent();
	initDraggable();
	initDropable();
	initJointJSGraph();
	registerMouseAndKeyEvents();
	zoomHandler = new ZoomHandler(paper);
	operatorFactory = new OperatorFactory(graph);
	undoRedoHandler = new UndoRedoHandler({ graph: graph });
	
	menu1 = [
	             {'Add Input Schema':function(menuItem,menu) { openInputDialog(); } },
	             $.contextMenu.separator,
	             {'Add Output Schema':function(menuItem,menu) { openOutputDialog(); } }
	           ];
	
});

function registerMouseAndKeyEvents() {
	$(document).mouseup(function(e) {
		zoomHandler.stopPanning(e);
	});

	paper.on('blank:pointerdown', function(e, x, y) {
		zoomHandler.startPanning(e);
	});
	
	paper.on('blank:contextmenu', function(e, x, y) {
		$('.cmenu1').contextMenu(menu1,{theme:'vista'});
	});

	graph.on('change', function(cell) { 
		makeDirty();
		execUndoableOperation();
	})
	
	graph.on('add', function(cell) { 
		makeDirty();
	})
	
	graph.on('remove', function(cell) { 
		makeDirty();
	})
	
	$(document).mousedown(function(e) {

	});

	$(document).mouseenter(function(e) {

	});

	$(document).mouseleave(function(e) {

	});

	$(document).mousemove(function(e) {
		zoomHandler.doPanning(e);
	});

	$(document).bind('mousewheel', function(e) {
		zoomHandler.changeZoom(e);
	});

	$(document).keydown(function(e) {
		if (e.keyCode == 46) {//delete key pressed
			if (selected){
				selected.remove();
			}
		}
		else if (e.keyCode == 90 && e.ctrlKey) {
			undoOperation();
		}
		else if (e.keyCode == 89 && e.ctrlKey) {
			redoOperation();
		}
	});
}

function registerTabChangeEvent() {
	$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
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
		position.x = ui.offset.left - $(this).offset().left;
		position.y = ui.offset.top - $(this).offset().top;
		var paperPoint = paper.clientToLocalPoint(position);
		operatorFactory.addOperator(type, paperPoint, type);
	}
}


function openInputDialog() {
	$('#myInput').bind("change", handleInputFileSelect);
	$('#myInput').click();
}

function openOutputDialog() {
	$('#myOutput').bind("change", handleOutputFileSelect);
	$('#myOutput').click();
}

function handleFileSelect(evt, box, isOutput) {
	var f = evt.target.files[0];
	if (f) {
		var reader = new FileReader();
		reader.readAsText(f);
		reader.onload = function(e) {
			var contents = e.target.result;
			console.log(contents);
			if (isOutput) {
				inputSchema = contents;
			} else {
				outputSchema = contents;
			}
			var obj = JSON.parse(contents);
			traverseObject(obj, 1, box, isOutput);
			relocateElement(box);
			undoRedoHandler.reset();
			makeDirty();
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
