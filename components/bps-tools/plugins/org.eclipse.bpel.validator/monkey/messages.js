
/*
 * Menu: Messages > Re-Load
 * License: EPL 1.0
 */
 
function alert(text) {

Packages.org.eclipse.jface.dialogs.MessageDialog.openInformation( 	
	window.getShell(), 	
	"Monkey Dialog", 
	text	
	)

}


function main() {
	alert("Hello world ...")
    Packages.org.eclipse.bpel.validator.model.Messages.clear();    
}