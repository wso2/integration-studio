var graph = null;
var paper = null;
var dialog;
var form;
var inputSchema;

$(document).ready(function () {
    
    registerTabChangeEvent();
    registerMouseAndKeyEvents();
    initDraggable();
    initDropable();
    initJointJSGraph();
});


function registerMouseAndKeyEvents() {

    $(document).on('mouseenter', '#dmEditorContainerContainerWrapper11', function () {
        //console.log("mouseenter = ");
    });

    $(document).on('mouseleave', '#dmEditorContainerContainerWrapper11', function () {
       // console.log("mouseleave = ");
    });

    $(document).mousemove(function (e) {// to get the cursor point to drop an icon
        //console.log("mousemove = " +e.pageX);
    });

    $(document).keydown(function (e) {
    	//console.log("keydown = " +e);
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
    sourceEditorTBox.val('<sequence name="sample_sequence">');
}


function activateDesignView() {
	console.log('activateDesignView');
    var sourceEditorTextBox = $('#sourceEditorTextBox');
    console.log(sequenceObj);
}

function openInputDialog() {
	$('#myInput').bind("change", handleInputFileSelect);
	$('#myInput').click();
}

function openOutputDialog() {
	$('#myOutput').bind("change", handleOutputFileSelect);
	$('#myOutput').click();
}

function handleInputFileSelect(evt) {
	alert('handleInputFileSelect');
    var f = evt.target.files[0]; 
    if (f) {
	      var reader = new FileReader();
	      reader.readAsText(f);
	      reader.onload = function(e) { 
		      var contents = e.target.result;
		      console.log(contents);
		  	  var obj = JSON.parse(contents);
			  traverseObject(obj, 1, mInput, true);
			  resizeHeightAtTheEnd(mInput);
	      }
    } else { 
    	  alert("Failed to load file");
    }
}

function handleOutputFileSelect(evt) {
    var f = evt.target.files[0]; 
    if (f) {
	      var reader = new FileReader();
	      reader.readAsText(f);
	      reader.onload = function(e) { 
		      var contents = e.target.result;
		      console.log(contents);
		  	  var obj = JSON.parse(contents);
			  traverseObject(obj, 1, mOutput, false);
			  resizeHeightAtTheEnd(mOutput);
	      }
    } else { 
    	  alert("Failed to load file");
    }
}

