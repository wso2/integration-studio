
function registerJsPlumbBind() {
    jsPlumb.bind("ready", function () {
    	jsPlumb.setContainer("#jsPlumbContainer");
    });
}


function jsplumbHandleDraggable() {
    $(".draggableIcon").draggable({
        helper: 'clone',
        containment: 'jsPlumbContainer',
        cursor: 'move',
        zIndex: 1000,
        //When first dragged
        stop: function (ev, ui) {

        }
    });
}


function jsplumbHandleDropable() {

    $("#jsPlumbContainer").droppable({
        drop: function (ev, ui) {//to locate the element
            if ($(ui.draggable).attr('id').search(/dragged/) == -1) {
                var newDraggedElem = $(ui.draggable).clone();
                newDraggedElem.removeClass("draggableIcon");
                newDraggedElem.removeClass("ui-draggable");
                var type = newDraggedElem.attr('id');
                createDiv("Concat", newDraggedElem, type);
            }
        },
        tolerance: "pointer"
    });

}


