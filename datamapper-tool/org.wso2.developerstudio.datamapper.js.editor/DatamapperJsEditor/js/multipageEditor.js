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
        width: 600,
        height: 200,
        model: graph,
        gridSize: 1
    });

    var rect = new joint.shapes.basic.Rect({
        position: { x: 100, y: 30 },
        size: { width: 100, height: 30 },
        attrs: { rect: { fill: 'green' }, text: { text: 'my box1', fill: 'red' } }
    });
 

    var rect2 = rect.clone();
    rect2.translate(300);

    var link = new joint.dia.Link({
        source: { id: rect.id },
        target: { id: rect2.id }
    });

    graph.addCells([rect, rect2, link]);

  
var jsonString = JSON.stringify(graph);
console.log(jsonString);


});


function initJsPlumb(container) {
    jsPlumb.setContainer(container);
}


function setUpdatedDataCallBack(obj) {
    var strID = CurElement.attr('id');
    var divMediator = document.getElementById(strID);
    $(divMediator).data('jsonConfig', obj);
    currentPopup.dialog("close");
}


function openMediatorConfigDialog(path, title) {

    if (popupCount == 0) {
        $(document.body).append('<div id="logMpopup"></div>');
        $("#logMpopup").attr('id', "logMpopup");
        $("#logMpopup").load(path);
        $("#logMpopup").dialog({ autoOpen: false,
            bgiframe: true,
            height: 400,
            width: 600,
            modal: false,
            draggable: true,
            resizable: true,
            position: 'center' });
        $("#logMpopup").dialog('option', 'title', title);
        currentPopup = $("#logMpopup");
        ++popupCount;
    }
    currentPopup.dialog("open");
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

function registerJsPlumbBind() {
    jsPlumb.bind("ready", function () {
        initJsPlumb($("#jsPlumbContainer"));
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






