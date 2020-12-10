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
 * Menu: Selection > Show Current
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
   alert("Hello World")
}