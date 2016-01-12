
var highlightCell=null;
var childHeight = 30;
var leafHeight = 30;
var mInput;

var avroString = '{"type" : "record", "name" : "engineer", "doc" : "Schema for org.wso2.avroSchemaGen.Engineer", "fields" : [ {"name" : "address","type" : [ "null", "string" ]	},{"name" : "fullname","type" : [ "null", "string" ]}    ]}';

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
        gridSize: 1,
        interactive: function(cellView, methodName) {
            if (cellView.model.get('isInteractive') === false) return false;
            return true;
        }
    });

    paper.on('cell:pointerdown', function(cellView) {
        selected = cellView.model;
        //console.log("selected = " + selected);
        if(cellView.model instanceof  joint.dia.Link) return;
        if(highlightCell) {
        	highlightCell.unhighlight();
        }
        highlightCell=cellView;
        cellView.highlight();
    });

    paper.on('blank:pointerclick', function(cellView) {
        selected = null;
        if(highlightCell) highlightCell.unhighlight();
        highlightCell=null;
    });
    
    mInput = new joint.shapes.devs.Model({
    	id:'inputBox',
	    position: { x: 50, y: 50 },
	    size: { width: 150, height: 400 },
	    attrs: {
	        '.label': { text: 'Input Type', 'text-anchor':'start', 'ref-x': .1},
	        rect: { fill: '#d3d3d3' },
	        '.outPorts circle': { fill: '#E74C3C' }
	    }
	});

	var mOutput = new joint.shapes.devs.Model({
    	id:'outputBox',
	    position: { x: 1050, y: 50 },
	    size: { width: 150, height: 400 },
	    inPorts: ['in'],
	    attrs: {
	        '.label': { text: 'Output Type', 'text-anchor':'start', 'ref-x': .1}, 
	        rect: { fill: 'gray' },
	        '.inPorts circle': { fill: '#E74C3C' }
	    }
	});
	
	graph.addCell(mInput);
	graph.addCell(mOutput);
	
//	var child1 = addOutputChild(mInput, 'Child001');
//    var child2 = addOutputChild(mInput, 'Child002');
// 	var child21 = addOutputChild(child2, 'Child0021');
// 	var child211 = addOutputChild(child21, 'Child00211');
 	
//    addOutputLeaf(child21, 'leaf2001');
//    addOutputLeaf(child21, 'leaf2002');
//    resizeHeightAtTheEnd(child21);
//   resizeHeightAtTheEnd(child2);
	//addOutputLeaf(child21, 'leaf2003');
	//var child22 = addOutputChild(child2, 'Child0022');
	
//	var child3 = addOutputChild(mInput, 'Child003');
	//var child31 = addOutputChild(child3, 'Child0031');

 	
	
	var obj = JSON.parse(avroString);
	alert(obj);
	traverseObject(obj, 1, mInput);
	resizeHeightAtTheEnd(mInput);
    //graph.fromJSON(JSON.parse('{"cells":[{"type":"basic.Rect","position":{"x":100,"y":30},"size":{"width":100,"height":30},"angle":0,"id":"4713e533-6d0f-48e3-8098-2fee3364d023","z":1,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"basic.Rect","position":{"x":238,"y":107},"size":{"width":100,"height":30},"angle":0,"id":"426e4cea-bb7e-46db-b6a2-75331764385b","embeds":"","z":2,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"link","source":{"id":"4713e533-6d0f-48e3-8098-2fee3364d023"},"target":{"id":"426e4cea-bb7e-46db-b6a2-75331764385b"},"id":"e32c2313-2f15-477d-804d-fd1c327b5944","z":3,"attrs":{}}]}'));

}

function addOutputChild(parent, childName) {
	var parentPosition = parent.get('position');
	
	var embededCells = parent.getEmbeddedCells();
	var embededCellsLength = parent.getEmbeddedCells().length;
	var totalHeight = 0;
	for (var i = 0; i < embededCellsLength; i++) {
		totalHeight += embededCells[i].get('size').height;
	}
	
	var newColor = getColorFromParent(parent);
	var childX = parentPosition.x + 20;
	var childY = parentPosition.y + childHeight + totalHeight;
	var child = new joint.shapes.basic.Rect({
		isInteractive: false,
	    position: { x: childX, y: childY },
	    size: { width: 100, height: leafHeight },
	    attrs: { rect: { fill: newColor,  stroke: 'none'}, text: { text: childName, 'text-anchor':'start', 'ref-x': .1, 'ref-y': .2} }
	});

	var parentHeight = 30 + childHeight + totalHeight;
	parent.set({
	     position: parent.get('position'),
	     size: { width: 100, height: parentHeight }
	});
	
	parent.embed(child);
	graph.addCell(child);
	return child;
}

function resizeHeightAtTheEnd(element){
	var embededCells = element.getEmbeddedCells();
	var embededCellsLength = element.getEmbeddedCells().length;
	var totalHeight = 0;
	for (var i = 0; i < embededCellsLength; i++) {
		totalHeight += embededCells[i].get('size').height;
	}
	var parentHeight = 30 + totalHeight;
	element.set({
	     position: element.get('position'),
	     size: { width: 100, height: parentHeight }
	});
}

function getColorFromParent(parent) {
	var color = parent.attr('rect/fill');
	var colorCode = color.substring(1,7);
	var step = '60606';
	var newColor = parseInt(colorCode, 16) + parseInt(step, 16);
	newColor = '#' + newColor.toString(16);
	return newColor;
}


function addOutputLeaf( parent, leafName ) {
	var leafHeight = 20;
	var parentPosition = parent.get('position');
	var newColor = getColorFromParent(parent);
	
	var embededCells = parent.getEmbeddedCells();
	var embededCellsLength = parent.getEmbeddedCells().length;
	var totalHeight = 0;
	for (var i = 0; i < embededCellsLength; i++) {
		totalHeight += embededCells[i].get('size').height;
	}
	
	var childX = parentPosition.x + 20;
	var childY = parentPosition.y + leafHeight + totalHeight;
	var outLeaf = new joint.shapes.devs.Model({
    	isInteractive: false,
	    size: { width: 80, height: leafHeight },
	    position: {x:childX, y:childY},
	    outPorts: [''],
	    attrs: {
	        '.label': { text: leafName, 'text-anchor':'start', 'ref-x': .1, 'ref-y': .2 },
	        rect: { fill: newColor,  stroke: 'none' },
	        '.outPorts circle': { fill: '#E74C3C' }
	    }
	});
	
	 parent.set({
         position: parent.get('position'),
         size: { width: 100, height: 30 + leafHeight + totalHeight }
     });

	parent.embed(outLeaf);
    graph.addCell(outLeaf);
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


function traverse(x, level, parent) {
	  if (isArray(x)) {
	    traverseArray(x, level, parent);
	  } else if ((typeof x === 'object') && (x !== null)) {
	    traverseObject(x, level, parent);
	  } else {
	    console.log(level + x);
	  }
	}
	 
	function isArray(o) {
	  return Object.prototype.toString.call(o) === '[object Array]';
	}
	 
	function traverseArray(arr, level, parent) {
	  console.log(level + "<array>");
	  arr.forEach(function(x) {
	    traverse(x, level + "  ", parent);
	  });
	}
	 
	function traverseObject(obj, level, parent) {
	  console.log(level + "<object>");
	  if(isArray(obj.fields)){
		  parent = addOutputChild(parent, obj.name);
	  } else {
		  addOutputLeaf(parent, obj.name);
	  }
	  for (var key in obj) {
	    if (obj.hasOwnProperty(key)) {
	      console.log(level + " xxx " + key + ":");
	      traverse(obj[key], level + "    ", parent);
	    }
	  }
	  resizeHeightAtTheEnd(parent);
	}

