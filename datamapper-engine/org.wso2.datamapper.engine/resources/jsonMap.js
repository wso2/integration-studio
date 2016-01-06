
function map_S_widget_S_widgetX(widget, widgetX) {
	widgetX.debugX = "mapped " + widget.debug;
	var window = widget.window;
	var windowX = widgetX.windowX;
	windowX.titleX = "mapped " + window.title;
	windowX.nameX = "mapped " + window.name;
	windowX.widthX = "mapped " + window.width;
	windowX.heightX = "mapped " + window.height;
	return widgetX;
}