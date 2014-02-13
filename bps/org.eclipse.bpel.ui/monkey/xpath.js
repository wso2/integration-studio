
/*
 * Menu: Misc > XPath Create
 * License: EPL 1.0
 */
 
function alert(text) {

Packages.org.eclipse.jface.dialogs.MessageDialog.openInformation( 	
	window.getShell(), 	
	"Monkey Dialog", 
	text	
	)

}

var XPathFactory = Packages.javax.xml.xpath.XPathFactory


function main() {
 // alert( XPathFactory.DEFAULT_OBJECT_MODEL_URI ) 
 
 var factory = XPathFactory.newInstance()
 // alert(factory)
 var xpath = factory.newXPath()
 alert(xpath)
}