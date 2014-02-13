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
public class XSDComplexTypeDefinitionAdapter extends XSDAbstractAdapter implements
		ILabeledElement {
	
	
	public Image getSmallImage(Object object) {		
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_XSD_COMPLEX_TYPE_DEFINITION_16);
	}
		
	
	public String getTypeLabel(Object object) {
		return Messages.XSDComplexTypeDefinitionAdapter_0; 
	}
	
}
