package org.eclipse.bpel.ui.figures;

/**
 * This interface should be implemented by EditParts which now how to react if 
 * a switch of layout orientation occurs.
 * @author ascharf
 *
 */
public interface ILayoutAware {

	/**
	 * Switches the layout to the new orientation. All necessary things to fulfill
	 * the switch has to be done here, e.g. setting the layout managers orientation,
	 * adding/removing border and stuff like that. 
	 * @param horizontal
	 */
	void switchLayout(boolean horizontal);
	
}
