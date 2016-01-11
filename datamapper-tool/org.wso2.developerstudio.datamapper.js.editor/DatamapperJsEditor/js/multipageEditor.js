var editorItemCounter = 0;
var currentId = null;
var count = 0;
var counter = 0;
var lastItem = null;
var lastItemInSwitch = null;
var dataString = null;
var CurElement = null;
var id = null;
var over = "false";
var CurElementisSource = null;
var CurElementisTarget = null;
var x = 170;
var topLocation = 170;
var CurXLoc = null;
var divwidth = 200;
var newElemXLoc = 60;
var topLoc = 120;
var elemSourceLocList = [];
var elemTargetLocList = [];
var elemSourceId = [];
var elemTargetId = [];
var elemSourceLocListIn = [];
var elemTargetLocListIn = [];
var elemSourceId1 = [];
var elemTargetId1 = [];
var elemSource = null;
var elemTarget = null;
var xSpace = 0;
var popupCount = 0;
var currentPopup = null;
var x2js = null;
var elemIsMiddle = false;
var graph =  null;


$(document).ready(function () {

    x2js = new X2JS();
    registerTabChangeEvent();
    registerMouseAndKeyEvents();
    registerJsPlumbBind();
    jsplumbHandleDraggable();
    jsplumbHandleDropable();
    
    graph = new joint.dia.Graph;

    var paper = new joint.dia.Paper({
        el: $('#jsPlumbContainer'),
        width: 1200,
        model: graph,
        gridSize: 1
    });
    
    paper.on('cell:pointerdown', function(cellView) {
        selected = cellView.model;
        //alert(selected);
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
	graph.addCell(mInput);
	
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
	graph.addCell(mOutput);

    //graph.fromJSON(JSON.parse('{"cells":[{"type":"basic.Rect","position":{"x":100,"y":30},"size":{"width":100,"height":30},"angle":0,"id":"4713e533-6d0f-48e3-8098-2fee3364d023","z":1,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"basic.Rect","position":{"x":238,"y":107},"size":{"width":100,"height":30},"angle":0,"id":"426e4cea-bb7e-46db-b6a2-75331764385b","embeds":"","z":2,"attrs":{"rect":{"fill":"green"},"text":{"fill":"red","text":"my box1"}}},{"type":"link","source":{"id":"4713e533-6d0f-48e3-8098-2fee3364d023"},"target":{"id":"426e4cea-bb7e-46db-b6a2-75331764385b"},"id":"e32c2313-2f15-477d-804d-fd1c327b5944","z":3,"attrs":{}}]}'));
});

function registerJsPlumbBind() {
    jsPlumb.bind("ready", function () {
    	jsPlumb.setContainer("#jsPlumbContainer");
    });
}



function registerMouseAndKeyEvents() {

    $(document).on('mouseenter', '#jsPlumbContainerWrapper11', function () {
        currentId = $(this).attr('id'); //alert(currentId);
        over = "true";
        console.log(over);

    });

    $(document).on('mouseleave', '#jsPlumbContainerWrapper11', function () {
        over = "false";
        console.log(over);

    });

    $(document).mousemove(function (e) {// to get the cursor point to drop an icon
        CurXLoc = e.pageX;
    });

    $(document).keydown(function (e) {
        designViewKeyDown(e);
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
    var prevElement = null;
    var nextElement = null;
    var connectionList = jsPlumb.getAllConnections();
    var jObj = null;
    var xmlElement = nul;
    var currentText = null;
    var sourceEditorTBox = $('#sourceEditorTextBox');

    sourceEditorTBox.val('<sequence name="sample_sequence">');

    for (var connection in connectionList) {
        if (connectionList.hasOwnProperty(connection)) {
            if (connectionList[connection].sourceId != null) {
                prevElement = document.getElementById(connectionList[connection].sourceId);
            }
            if (connectionList[connection].targetId != null) {
                nextElement = document.getElementById(connectionList[connection].targetId);
            }
        }

        jObj = $(prevElement).data('jsonConfig');
        console.log(prevElement);
        console.log('serializing ' + jObj);
        console.log(jObj);
        xmlElement = '\n' + x2js.json2xml_str(jObj);
        currentText = sourceEditorTBox.val();
        sourceEditorTBox.val(currentText + xmlElement);
    }

    jObj = $(nextElement).data('jsonConfig');
    console.log('serializing ' + jObj);
    console.log(jObj);
    xmlElement = '\n' + x2js.json2xml_str(jObj);
    currentText = sourceEditorTBox.val();
    sourceEditorTBox.val(currentText + xmlElement + '\n</sequence>');
}


function activateDesignView() {
    var sourceEditorTextBox = $('#sourceEditorTextBox');
    var jsPlumbCont = $("#jsPlumbContainer");

    console.log('activateDesignView');
    var sequenceObj = x2js.xml_str2json(sourceEditorTextBox.val());
    var sequence = sequenceObj.sequence;
    var logArray = sequence.log;
    console.log(logArray);

    jsPlumbCont.empty();
    var prevDivElement = null;
    for (var i = 0; i < logArray.length; i++) {
        console.log(logArray[i]);
        var currentDiv = AddDiv(logArray[i]);
        if (prevDivElement != null) {
            connectDivs(prevDivElement, currentDiv);
        }
        prevDivElement = currentDiv;
    }

}






