var graph = null;
var paper = null;

$(document).ready(function () {
    
    registerTabChangeEvent();
    registerMouseAndKeyEvents();
    //load following functions from designEditor.js
    registerJsPlumbBind();
    jsplumbHandleDraggable();
    jsplumbHandleDropable();
    
    initJointJSGraph();

});


function initJointJSGraph() {
    graph = new joint.dia.Graph;

    paper = new joint.dia.Paper({
        el: $('#jsPlumbContainer'),
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

function registerMouseAndKeyEvents() {

    $(document).on('mouseenter', '#jsPlumbContainerWrapper11', function () {
        console.log("mouseenter = ");

    });

    $(document).on('mouseleave', '#jsPlumbContainerWrapper11', function () {
        console.log("mouseleave = ");

    });

    $(document).mousemove(function (e) {// to get the cursor point to drop an icon
        console.log("mousemove = " +e.pageX);
    });

    $(document).keydown(function (e) {
    	console.log("keydown = " +e);
        //designViewKeyDown(e);
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
    sourceEditorTBox.val('<sequence name="sample_sequence">');
}


function activateDesignView() {
	console.log('activateDesignView');
    var sourceEditorTextBox = $('#sourceEditorTextBox');
    console.log(sequenceObj);
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




