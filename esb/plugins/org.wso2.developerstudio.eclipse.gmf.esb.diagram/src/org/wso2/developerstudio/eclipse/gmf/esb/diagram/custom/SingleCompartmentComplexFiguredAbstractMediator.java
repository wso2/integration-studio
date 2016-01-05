package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.gmf.runtime.notation.View;

public class SingleCompartmentComplexFiguredAbstractMediator extends complexFiguredAbstractMediator{

	public SingleCompartmentComplexFiguredAbstractMediator(View view) {
		super(view);
	}
	
	/**
	 * This method should be implemented by sub classes
	 */
	public EsbGroupingShape getPrimaryShape() {
		return null;
	}

}
