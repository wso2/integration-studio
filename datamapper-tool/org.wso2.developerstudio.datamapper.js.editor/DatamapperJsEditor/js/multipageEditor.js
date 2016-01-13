var graph = null;
var paper = null;

$(document).ready(function () {
    
    registerTabChangeEvent();
    registerMouseAndKeyEvents();
    //load following functions from designEditor.js
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

