var selectedCell = null;
var leafHeight = 30;

var rectangleTemplate = {fill : '#d3d3d3'};
var circleTemplate = {fill : '#E74C3C'};
var rootWidth = 300;
var rootHeight = 400;
var initialSize = {width : rootWidth, height : rootHeight};
var childSize = {width : 100, height : leafHeight};
var inputPosition = {x : 50, y : 50};
var outputPosition = {x : 1050, y : 50};


function initJointJSGraph() {

	graph = new joint.dia.Graph;
	paper = new joint.dia.Paper({
		el : $('#dmEditorContainer'),
		width : 1200,
		model : graph,
		gridSize : 1,
		interactive : function(cellView, methodName) {
			if (cellView.model.get('isInteractive') === false)
				return false;
			return true;
		}
	});

	paper.on('cell:pointerdown', function(cellView) {
		selected = cellView.model;
		if (cellView.model instanceof joint.dia.Link){
			return;
		}
		if (selectedCell) {
			selectedCell.unhighlight();
		}
		selectedCell = cellView;
		cellView.highlight();
	});

	paper.on('blank:pointerclick', function(cellView) {
		selected = null;
		if (selectedCell){
			selectedCell.unhighlight();
		}
		selectedCell = null;
	});

	
	var inputLabel = getLabelText("Output Type");
	mInput = new joint.shapes.devs.Model({
		id : 'inputBox',
		position : inputPosition,
		size : initialSize,
		attrs : {
			'.label' : inputLabel,
			rect : rectangleTemplate,
			'.outPorts circle' : circleTemplate
		}
	});

	var outputLabel = getLabelText("Output Type");
	mOutput = new joint.shapes.devs.Model({
		id : 'outputBox',
		position : outputPosition,
		size : initialSize,
		attrs : {
			'.label' : outputLabel,
			rect : rectangleTemplate,
			'.inPorts circle' : circleTemplate
		}
	});

	graph.addCells([mInput, mOutput]);
}

function getTotalHeightOfChidlren(parent){
	var embededCells = parent.getEmbeddedCells();
	var embededCellsLength = parent.getEmbeddedCells().length;
	var totalHeight = 0;
	for (var i = 0; i < embededCellsLength; i++) {
		totalHeight += embededCells[i].get('size').height;
	}
	return totalHeight;
}

function getPositionRelativeToParent(parent, totalHeight) {
	var parentPosition = parent.get('position');
	var childX = parentPosition.x + 20;
	var childY = parentPosition.y + leafHeight + totalHeight;
	var childPosition = {};
	childPosition.x = childX;
	childPosition.y = childY;
	return childPosition;
}

function getChildRect(parent) {
	var newColor = getColorFromParent(parent);
	var childRect = {};
	childRect.fill = newColor;
	childRect.stroke = 'none';
	return childRect;
}

function getChildText(childName) {
	var childText = {text : childName, 'text-anchor' : 'start', 'ref-x' : .1, 'ref-y' : .1};
	return childText;
}

function getLabelText(labelText) {
	var labelText = {text : labelText, 'text-anchor' : 'start', 'ref-x' : .1, 'ref-y' : .1};
	return labelText;
}

function relocateElement(element, parentHeight) {
	var ownPosition = element.get('position');
	element.set({
		position : ownPosition,
		size : {
			width : 100,
			height : parentHeight
		}
	});
}

function addChildRectangle(parent, childName) {
	var totalHeight = getTotalHeightOfChidlren(parent);
	var childPosition = getPositionRelativeToParent(parent, totalHeight);
	var childRect = getChildRect(parent);
	var childText = getChildText(childName);
	
	var child = new joint.shapes.basic.Rect({
		isInteractive : false,
		position : childPosition,
		size : childSize,
		attrs : {
			rect : childRect,
			text : childText
		}
	});

	var parentHeight = 30 + leafHeight + totalHeight;
	relocateElement(parent, parentHeight);
	parent.embed(child);
	graph.addCell(child);
	return child;
}

function addLeaf(parent, leafName, isOutput) {
	var totalHeight = getTotalHeightOfChidlren(parent);
	var childPosition = getPositionRelativeToParent(parent, totalHeight);
	var childRect = getChildRect(parent);
	var childText = getLabelText(leafName);
	
	var leaf = null;
	if (isOutput) {
		leaf = new joint.shapes.devs.Model({
			isInteractive : false,
			size : childSize,
			position : childPosition,
			outPorts : [ '' ],
			attrs : {
				'.label' : childText,
				rect : childRect,
				'.outPorts circle' :circleTemplate
			}
		});
	} else {
		leaf = new joint.shapes.devs.Model({
			isInteractive : false,
			size : childSize,
			position : childPosition,
			inPorts : [ '' ],
			attrs : {
				'.label' : childText,
				rect : childRect,
				'.inPorts circle' :circleTemplate
			}
		});
	}

	var parentHeight = 30 + leafHeight + totalHeight;
	relocateElement(parent, parentHeight);
	parent.embed(leaf);
	graph.addCell(leaf);
}

function resizeHeightAtTheEnd(element) {
	var totalHeight =getTotalHeightOfChidlren(element);
	var parentHeight = 30 + totalHeight;
	relocateElement(element, parentHeight);
}

function getColorFromParent(parent) {
	var color = parent.attr('rect/fill');
	var colorCode = color.substring(1, 7);
	var step = '60606';
	var newColor = parseInt(colorCode, 16) + parseInt(step, 16);
	newColor = '#' + newColor.toString(16);
	return newColor;
}

function createDiv(objName, image, type) {

	var m1 = new joint.shapes.devs.Model({
		size : {
			width : 90,
			height : 90
		},
		inPorts : [ 'in1', 'in2' ],
		outPorts : [ 'out' ],
		attrs : {
			'.label' : {
				text : objName,
				'ref-x' : .4,
				'ref-y' : .2
			},
			rect : {
				fill : '#2ECC71'
			},
			'.inPorts circle' : {
				fill : '#16A085'
			},
			'.outPorts circle' : {
				fill : '#E74C3C'
			}
		}
	});
	graph.addCell(m1);
}

function traverse(x, level, parent, isOutput) {
	if (isArray(x)) {
		traverseArray(x, level, parent, isOutput);
	} else if ((typeof x === 'object') && (x !== null)) {
		traverseObject(x, level, parent, isOutput);
	} else {
		console.log(level + x);
	}
}

function isArray(o) {
	return Object.prototype.toString.call(o) === '[object Array]';
}

function traverseArray(arr, level, parent, isOutput) {
	console.log(level + "<array>");
	arr.forEach(function(x) {
		traverse(x, level + "  ", parent, isOutput);
	});
}

function traverseObject(obj, level, parent, isOutput) {
	console.log(level + "<object>");
	if (isArray(obj.fields)) {
		parent = addChildRectangle(parent, obj.name);
	} else {
		addLeaf(parent, obj.name, isOutput);
	}
	for (var key in obj) {
		if (obj.hasOwnProperty(key)) {
			console.log(level + " xxx " + key + ":");
			traverse(obj[key], level + "    ", parent, isOutput);
		}
	}
	resizeHeightAtTheEnd(parent);
}
