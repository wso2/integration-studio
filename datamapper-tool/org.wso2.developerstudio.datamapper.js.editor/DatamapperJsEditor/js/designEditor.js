var selectedCell = null;
var leafHeight = 30;
var xOffset = 20;
var yOffset = 30;
var rootWidth = 300;
var rootHeight = 400;
var paperWidth = 1200;
var commandManager = null;

var rectangleTemplate = {fill : '#d3d3d3', stroke : 'none'};
var circleTemplate = {fill : '#6495ED'};
var initialSize = {width : rootWidth, height : rootHeight};
var inputPosition = {x : 50, y : 50};
var outputPosition = {x : 1050, y : 50};

function getColorFromParent(parent) {
	var color = parent.attr('rect/fill');
	var colorCode = color.substring(1, 7);
	var step = '60606';
	var newColor = parseInt(colorCode, 16) + parseInt(step, 16);
	newColor = '#' + newColor.toString(16);
	return 'white';
}

function getChildRect(parent) {
	var newColor = getColorFromParent(parent);
	var childRect = {};
	childRect.fill = newColor;
	childRect.stroke = 'none';
	return childRect;
}


function getLabelText(labelText) {
	var labelText = {text : labelText, 'text-anchor' : 'start', "ref-y":5,"ref-x":5, "font-size": 24, "font-family": "Arial"};
	return labelText;
}

function getOutputLabelText(labelText) {
	var labelText = {text : labelText, 'text-anchor' : 'start', "ref-y":5,"ref-x":15, "font-size": 24, "font-family": "Arial"};
	return labelText;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


function initJointJSGraph() {

	graph = new joint.dia.Graph;
	
	paper = new joint.dia.Paper({
		el : $('#dmEditorContainer'),
		width : paperWidth,
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
			rect :  {fill : '#6495ED', stroke : 'black'},
			'.outPorts circle' : circleTemplate
		}
	});

	var outputLabel = getLabelText("Input Type");
	mOutput = new joint.shapes.devs.Model({
		id : 'outputBox',
		position : outputPosition,
		size : initialSize,
		attrs : {
			'.label' : outputLabel,
			rect :  {fill : '#6495ED', stroke : 'black'},
			'.inPorts circle' : circleTemplate
		}
	});

	graph.addCells([mInput, mOutput]);
	commandManager = new joint.dia.CommandManager({ graph: graph });
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

function relocateElement(element) {
	var ownPosition = element.get('position');
	var ownSize = element.get('size');
	var siblingsHeight = getTotalHeightOfChidlren(element);
	var finalHeight = siblingsHeight + leafHeight;
	element.set({
		position : ownPosition,
		size : {
			width : ownSize.width,
			height : finalHeight 
		}
	});
}

function getChildSize(parent){
	var parentSize = parent.get('size');
	var childWidth = parentSize.width - xOffset;
	var childHeight = leafHeight;
	var childSize = {width : childWidth, height : childHeight};
	return childSize;
}

function getFirstChildSize(parent){
	var parentSize = parent.get('size');
	var childWidth = parentSize.width;
	var childHeight = leafHeight;
	var childSize = {width : childWidth, height : childHeight};
	return childSize;
}

function getChildPosition(parent){
	var parentPosition = parent.get('position');
	var childX = parentPosition.x + xOffset;
	var siblingsHeight = getTotalHeightOfChidlren(parent);
	var childY = parentPosition.y + siblingsHeight + yOffset;
	var childSize = {x : childX, y : childY};
	return childSize;
}

function getFirstChildPosition(parent){
	var parentPosition = parent.get('position');
	var childX = parentPosition.x;
	var siblingsHeight = getTotalHeightOfChidlren(parent);
	var childY = parentPosition.y + siblingsHeight + yOffset;
	var childSize = {x : childX, y : childY};
	return childSize;
}

function addNode(parent, childName, level) {
	var childRect = getChildRect(parent);
	var childText = getLabelText(childName);
	var childPosition;
	var childSize;
	if (level===2) {
	  childPosition = getFirstChildPosition(parent);
	  childSize =  getFirstChildSize(parent);
	} else{
	  childPosition = getChildPosition(parent);
	  childSize =  getChildSize(parent);
	}
	
	
	var child = new joint.shapes.devs.Model({
		isInteractive : false,
		size : childSize,
		position : childPosition,
		attrs : {
			'.label' : childText,
			rect : childRect
		}
	});

	parent.embed(child);
	graph.addCell(child);
	return child;
}

function addLeaf(parent, leafName, level, isOutput) {
	var childRect = getChildRect(parent);
	var childText = getLabelText(leafName);
	var childPosition = getChildPosition(parent);
	var childSize =  getChildSize(parent);
	
	var leaf = null;
	if (isOutput) {
		leaf = new joint.shapes.devs.Model({
			isInteractive : false,
			size : childSize,
			position : childPosition,
			outPorts : [ '' ],
			attrs : {
				'.label' : childText,
				'graphProperties': { index : -1	},
				rect : childRect,
				circle: { r: 6},
				'.outPorts circle' : circleTemplate
			}
		});
	} else {
		childText = getOutputLabelText(leafName);
		leaf = new joint.shapes.devs.Model({
			isInteractive : false,
			size : childSize,
			position : childPosition,
			inPorts : [ '' ],
			attrs : {
				'.label' : childText,
				'graphProperties': { index : -1	},
				rect : childRect,
				circle: { r: 6},
				'.inPorts circle' : circleTemplate
			}
		});
	}

	parent.embed(leaf);
	graph.addCell(leaf);
}


function traverse(x, level, parent, isOutput) {
	if (isArray(x)) {
		traverseArray(x, level, parent, isOutput);
	} else if ((typeof x === 'object') && (x !== null)) {
		traverseObject(x, level, parent, isOutput);
	} else {
		console.log(level + x);
	}
	relocateElement(parent);
}

function isArray(o) {
	return Object.prototype.toString.call(o) === '[object Array]';
}

function traverseArray(arr, level, parent, isOutput) {
	//console.log(level + "<array>");
	arr.forEach(function(x) {
		traverse(x, level + 1, parent, isOutput);
	});
}

function traverseObject(obj, level, parent, isOutput) {
	//console.log(level + "<object>");
	if (isArray(obj.fields)) {
		parent = addNode(parent, obj.name, level+1);
	} else {
		addLeaf(parent, obj.name, level+1, isOutput);
	}
	for (var key in obj) {
		if (obj.hasOwnProperty(key)) {
			//console.log(" level " + level + " key " + key);
			traverse(obj[key], level + 1, parent, isOutput);
		}
	}
}
