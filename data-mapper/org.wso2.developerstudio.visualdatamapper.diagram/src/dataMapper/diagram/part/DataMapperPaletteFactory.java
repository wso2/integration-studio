package dataMapper.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import dataMapper.Element;
import dataMapper.diagram.edit.parts.AttributeEditPart;
import dataMapper.diagram.edit.parts.DataMapperDiagramEditPart;
import dataMapper.diagram.edit.parts.ElementEditPart;
import dataMapper.diagram.edit.parts.InNode2EditPart;
import dataMapper.diagram.edit.parts.InNodeEditPart;
import dataMapper.diagram.edit.parts.InputEditPart;
import dataMapper.diagram.edit.parts.OutNode2EditPart;
import dataMapper.diagram.edit.parts.OutNodeEditPart;
import dataMapper.diagram.edit.parts.OutputEditPart;

import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.ui.part.IShowInSource;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart.ConnectionRefreshMgr;

/**
 * @generated
 */
public class DataMapperPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDataMapper1Group());
	}

	/**
	 * Creates "dataMapper" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createDataMapper1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				dataMapper.diagram.part.Messages.DataMapper1Group_title);
		paletteContainer.setId("createDataMapper1Group"); //$NON-NLS-1$
		paletteContainer.add(createOperators1CreationTool());
		paletteContainer.add(createDataMapperLink2CreationTool());
		paletteContainer.add(createConcat3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperators1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				dataMapper.diagram.part.Messages.Operators1CreationTool_title,
				dataMapper.diagram.part.Messages.Operators1CreationTool_desc,
				Collections
						.singletonList(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperDiagram_2001));
		entry.setId("createOperators1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(dataMapper.diagram.providers.DataMapperElementTypes
				.getImageDescriptor(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperDiagram_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataMapperLink2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				dataMapper.diagram.part.Messages.DataMapperLink2CreationTool_title,
				dataMapper.diagram.part.Messages.DataMapperLink2CreationTool_desc,
				Collections
						.singletonList(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002));
		entry.setId("createDataMapperLink2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(dataMapper.diagram.providers.DataMapperElementTypes
				.getImageDescriptor(dataMapper.diagram.providers.DataMapperElementTypes.DataMapperLink_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConcat3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				dataMapper.diagram.part.Messages.Concat3CreationTool_title,
				dataMapper.diagram.part.Messages.Concat3CreationTool_desc,
				Collections
						.singletonList(dataMapper.diagram.providers.DataMapperElementTypes.Concat_3013));
		entry.setId("createConcat3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(dataMapper.diagram.providers.DataMapperElementTypes
				.getImageDescriptor(dataMapper.diagram.providers.DataMapperElementTypes.Concat_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		private EditPart getRoot(EditPart editPart) {
			EditPart temp = editPart.getParent();
			while ((!(temp instanceof DataMapperDiagramEditPart))
					&& (temp != null)) {
				// System.out.println("Node     " +temp);
				// System.out.println("NodeNodeNodeNodeNodeNodeNodeNode     "
				// +childEditPart.getClass().getName() );
				if (temp instanceof InputEditPart) {
					return temp;
					/*
					 * if (childEditPart instanceof InNodeEditPart) { NodeFigure
					 * figureInput = ((InNodeEditPart) childEditPart)
					 * .getNodeFigureOutput(); figureInput.removeAll(); Figure
					 * emptyFigure = new Figure(); figureInput.add(emptyFigure);
					 * break; } else { NodeFigure figureInput =
					 * ((InNode2EditPart) childEditPart) .getNodeFigureOutput();
					 * figureInput.removeAll(); Figure emptyFigure = new
					 * Figure(); figureInput.add(emptyFigure); break; }
					 */
				} else if (temp instanceof OutputEditPart) {
					return temp;
				}

				temp = temp.getParent();

			}
			return null;
		}

		/**
		 * @generated NOT
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes) {

				/*
				 * hacking out/In Node for Element & Attribute to make mapping
				 */

				@Override
				protected Command getCommand() {

					/*
					 * for Element
					 */
					if (getTargetEditPart() instanceof ElementEditPart) {
						// System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

						for (int i = 0; i < ((ElementEditPart) getTargetEditPart())
								.getChildren().size(); ++i) {

							if (getRoot(getTargetEditPart()) instanceof OutputEditPart) {

								if (((ElementEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof InNodeEditPart) {
									return ((EditPart) ((ElementEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								} else if (((ElementEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof InNode2EditPart) {
									return ((InNode2EditPart) ((ElementEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}
							} else if (getRoot(getTargetEditPart()) instanceof InputEditPart) {

								if (((ElementEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof OutNodeEditPart) {
									return ((OutNodeEditPart) ((ElementEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								} else if (((ElementEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof OutNode2EditPart) {
									return ((OutNode2EditPart) ((ElementEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}

							}

						}// for
					}// for element mouse enter

					/*
					 * for attribute
					 */
					else if (getTargetEditPart() instanceof AttributeEditPart) {
						for (int i = 0; i < ((AttributeEditPart) getTargetEditPart())
								.getChildren().size(); ++i) {

							if (getRoot(getTargetEditPart()) instanceof OutputEditPart) {
								if (((AttributeEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof InNodeEditPart) {
									return ((InNodeEditPart) ((AttributeEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}

								else if (((AttributeEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof InNode2EditPart) {
									return ((InNode2EditPart) ((AttributeEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}
							}

							else if (getRoot(getTargetEditPart()) instanceof InputEditPart) {
								if (((AttributeEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof OutNodeEditPart) {
									return ((OutNodeEditPart) ((AttributeEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}

								else if (((AttributeEditPart) getTargetEditPart())
										.getChildren().get(i) instanceof OutNode2EditPart) {
									return ((OutNode2EditPart) ((AttributeEditPart) getTargetEditPart())
											.getChildren().get(i))
											.getCommand(getTargetRequest());

								}
							}

						}// for
					}// for attribute mouse enter

					return super.getCommand();
				}// get command
			}; // UnspecifiedTypeConnectionTool

			tool.setProperties(getToolProperties());
			return tool;
		}// create tool
	}
}
