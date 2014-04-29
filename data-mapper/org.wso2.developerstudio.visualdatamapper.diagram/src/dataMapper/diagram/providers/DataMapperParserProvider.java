package dataMapper.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DataMapperParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser treeNodeName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTreeNodeName_5002Parser() {
		if (treeNodeName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { dataMapper.DataMapperPackage.eINSTANCE
					.getTreeNode_Name() };
			dataMapper.diagram.parsers.MessageFormatParser parser = new dataMapper.diagram.parsers.MessageFormatParser(
					features);
			treeNodeName_5002Parser = parser;
		}
		return treeNodeName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser treeNodeName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getTreeNodeName_5001Parser() {
		if (treeNodeName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { dataMapper.DataMapperPackage.eINSTANCE
					.getTreeNode_Name() };
			dataMapper.diagram.parsers.MessageFormatParser parser = new dataMapper.diagram.parsers.MessageFormatParser(
					features);
			treeNodeName_5001Parser = parser;
		}
		return treeNodeName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser elementName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getElementName_5004Parser() {
		if (elementName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { dataMapper.DataMapperPackage.eINSTANCE
					.getElement_Name() };
			dataMapper.diagram.parsers.MessageFormatParser parser = new dataMapper.diagram.parsers.MessageFormatParser(
					features);
			elementName_5004Parser = parser;
		}
		return elementName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser treeNodeName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getTreeNodeName_5003Parser() {
		if (treeNodeName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { dataMapper.DataMapperPackage.eINSTANCE
					.getTreeNode_Name() };
			dataMapper.diagram.parsers.MessageFormatParser parser = new dataMapper.diagram.parsers.MessageFormatParser(
					features);
			treeNodeName_5003Parser = parser;
		}
		return treeNodeName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case dataMapper.diagram.edit.parts.TreeNodeNameEditPart.VISUAL_ID:
			return getTreeNodeName_5002Parser();
		case dataMapper.diagram.edit.parts.TreeNodeName2EditPart.VISUAL_ID:
			return getTreeNodeName_5001Parser();
		case dataMapper.diagram.edit.parts.ElementNameEditPart.VISUAL_ID:
			return getElementName_5004Parser();
		case dataMapper.diagram.edit.parts.TreeNodeName3EditPart.VISUAL_ID:
			return getTreeNodeName_5003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(dataMapper.diagram.part.DataMapperVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (dataMapper.diagram.providers.DataMapperElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
