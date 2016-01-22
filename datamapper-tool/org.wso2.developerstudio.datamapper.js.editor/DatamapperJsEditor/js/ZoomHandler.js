var ZoomHandler = function (paper) {
	this.paper = paper;
	this.mouseState = '';
	this.startCoords = [];
	this.last = [0, 0];
};

ZoomHandler.prototype.changeZoom = function(e, pageOffset, delta1) {
	 e.preventDefault();
     e = e.originalEvent;
	 var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail))) / 50;
     var offsetX = (e.offsetX || e.clientX - pageOffset.left); // offsetX is not defined in FF
     var offsetY = (e.offsetY || e.clientY - pageOffset.top); // offsetY is not defined in FF
     var p = offsetToLocalPoint(this.paper, offsetX, offsetY);
     var newScale = V(this.paper.viewport).scale().sx + delta; // the current paper scale changed by delta

     if (newScale > 0.4 && newScale < 2) {
         this.paper.setOrigin(0, 0); // reset the previous viewport translation
         this.paper.scale(newScale, newScale, p.x, p.y);
     } 
};

function offsetToLocalPoint(paper, x, y) {
    var svgPoint = paper.svg.createSVGPoint();
    svgPoint.x = x;
    svgPoint.y = y;
    // Transform point into the viewport coordinate system.
    var pointTransformed = svgPoint.matrixTransform(paper.viewport.getCTM().inverse());
    return pointTransformed;
}

ZoomHandler.prototype.setStartMouseCoords = function(e) {
	this.mouseState = 'pan';
	this.startCoords = [
	               e.offsetX - this.last[0],
	               e.offsetY - this.last[1]
	          ];
}
	
ZoomHandler.prototype.updateLastMouseCoords = function(e) {
	this.mouseState = '';
	this.last = [
	        e.offsetX - this.startCoords[0], // set last coordinates
	        e.offsetY - this.startCoords[1]
	    ];
}
      
ZoomHandler.prototype.changeCenter = function(e) {
	if (this.mouseState == 'pan') {
		 var x = e.offsetX;
		 var y = e.offsetY;
		 paper.setOrigin(x - this.startCoords[0], y - this.startCoords[1]);
    }
};
