/**
 * 
 */
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * @author mchmiele
 *
 */
public class XSDSimpleTypeDefinitionAdapter extends XSDAbstractAdapter  {

	
	public Image getSmallImage(Object object) {		
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_XSD_SIMPLE_TYPE_DEFINITION_16);
	}
		
	
	public String getTypeLabel(Object object) {
		return Messages.XSDSimpleTypeDefinitionAdapter_0; 
	}	
}
