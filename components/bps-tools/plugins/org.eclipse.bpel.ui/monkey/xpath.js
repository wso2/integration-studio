/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

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