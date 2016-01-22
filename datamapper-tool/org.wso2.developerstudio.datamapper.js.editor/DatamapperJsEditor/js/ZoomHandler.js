var ZoomHandler = function(paper) {
	this.paper = paper;
	this.mouseState = '';
	this.startCoords = [];
	this.last = [ 0, 0 ];
};

ZoomHandler.prototype.changeZoom = function(e) {
	e.preventDefault();
	e = e.originalEvent;
	var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail))) / 50;
	var offsetX = (e.offsetX || e.clientX - $(e.target).offset().left); // offsetX is not defined in FF
	var offsetY = (e.offsetY || e.clientY - $(e.target).offset().top); // offsetY is not defined in FF
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
	var pointTransformed = svgPoint.matrixTransform(paper.viewport.getCTM()
			.inverse());
	return pointTransformed;
}

ZoomHandler.prototype.startPanning = function(e) {
	this.mouseState = 'pan';
	var offsetX = (e.offsetX || e.clientX - $(e.target).offset().left);
	var offsetY = (e.offsetY || e.clientY - $(e.target).offset().top);
	this.startCoords = [ offsetX - this.last[0], offsetY - this.last[1] ];
}

ZoomHandler.prototype.stopPanning = function(e) {
	this.mouseState = '';
	var offsetX = (e.offsetX || e.clientX - $(e.target).offset().left);
	var offsetY = (e.offsetY || e.clientY - $(e.target).offset().top);
	this.last = [ offsetX - this.startCoords[0], // set last coordinates
	offsetY - this.startCoords[1] ];
}

ZoomHandler.prototype.doPanning = function(e) {
	if (this.mouseState == 'pan') {
		var offsetX = (e.offsetX || e.clientX - $(e.target).offset().left);
		var offsetY = (e.offsetY || e.clientY - $(e.target).offset().top);
		var x = offsetX;
		var y = offsetY;
		paper.setOrigin(x - this.startCoords[0], y - this.startCoords[1]);
	}
};
