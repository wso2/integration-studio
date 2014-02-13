package org.eclipse.bpel.examples.extensionpoints.palette;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BPELCreationToolEntry;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 21, 2007
 *
 */

public class EmptyToolEntry extends BPELCreationToolEntry {

	/**
	 * Use the default constructor.
	 */
	static UIObjectFactoryProvider fProvider = ExitToolEntry.fProvider;
	
	/**
	 * 
	 */
	public EmptyToolEntry () {
		super("Empty", "Empty", fProvider.getFactoryFor(BPELPackage.eINSTANCE.getEmpty()) );
	}

}
