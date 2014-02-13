package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class DefaultSizeCaseBranchPointerNodeFigure extends
		DefaultSizeNodeFigure {

	private static final String INPUT_ANCHOR_TERMINAL = "input_anchor_terminal";

	private static final String OUTPUT_ANCHOR_TERMINAL = "output_anchor_terminal";

	// private static int switch_case_branch_figure=0;

	private PointerInputAnchor inputAnchor;

	private PointerOutputAnchor outputAnchor;

	private int id;

	public DefaultSizeCaseBranchPointerNodeFigure(int width, int height,
			AbstractPointerShape pointerShape) {
		super(width, height);
		this.inputAnchor = new PointerInputAnchor(pointerShape);
		this.outputAnchor = new PointerOutputAnchor(pointerShape);
		this.id = -1;
	}

	/**
	 * {@inheritDoc}
	 */
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		if (terminal.equals(INPUT_ANCHOR_TERMINAL)) {
			return inputAnchor;
		} else if (terminal.equals(OUTPUT_ANCHOR_TERMINAL)) {
			return outputAnchor;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getConnectionAnchorTerminal(ConnectionAnchor c) {
		if (c == inputAnchor) {
			return INPUT_ANCHOR_TERMINAL;
		} else if (c == outputAnchor) {
			return OUTPUT_ANCHOR_TERMINAL;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return outputAnchor;
	}

	/**
	 * {@inheritDoc}
	 */
	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return inputAnchor;
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean useLocalCoordinates() {
		return true;
	}

	
	public String toString() {

		return "pointer connector: " + id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
