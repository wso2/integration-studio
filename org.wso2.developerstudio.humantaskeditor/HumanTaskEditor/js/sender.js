var saveFile = function() {
    IDESaveContent(document.getElementById("editor").value);
}

var makeDirty = function() {
    IDESetDirty(true);
}

var loadFileContent = function() {
    document.getElementById("editor").value = IDEGetFileContent();
}

var onFocusGain = function() {
    getIDEDirtyContent();
    loadJSON();
}

var onFocusLost = function(){
    setIDEDirtyContent();
}

var getIDEDirtyContent = function(){
    document.getElementById("editor").value = IDEGetDirtyContent();
}

var setIDEDirtyContent = function(){
    IDESetDirtyContent(document.getElementById("editor").value);
}

var setFocus = function(){
	IDESetFocusToEditorPart();
}

var loadJSON = function(){
	document.getElementById("editor2").value = HTEditorLoadModel();
}

