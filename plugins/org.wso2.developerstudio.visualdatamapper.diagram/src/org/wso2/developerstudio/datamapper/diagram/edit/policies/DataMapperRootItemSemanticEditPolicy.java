package org.wso2.developerstudio.datamapper.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.AbsoluteValueCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.AddCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.CeliCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ConcatCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ConstantCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ContainsCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.DivideCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.EqualCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.FloorCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.InputCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.LowerCaseCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.MultiplyCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.OutputCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.RoundCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SetPrecisionCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SplitCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SubtractCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.UpperCaseCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;

/**
 * @generated
 */
public class DataMapperRootItemSemanticEditPolicy extends DataMapperBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataMapperRootItemSemanticEditPolicy() {
		super(DataMapperElementTypes.DataMapperRoot_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DataMapperElementTypes.Input_2002 == req.getElementType()) {
			return getGEFWrapper(new InputCreateCommand(req));
		}
		if (DataMapperElementTypes.Output_2003 == req.getElementType()) {
			return getGEFWrapper(new OutputCreateCommand(req));
		}
		if (DataMapperElementTypes.Equal_2005 == req.getElementType()) {
			return getGEFWrapper(new EqualCreateCommand(req));
		}
		if (DataMapperElementTypes.Subtract_2013 == req.getElementType()) {
			return getGEFWrapper(new SubtractCreateCommand(req));
		}
		if (DataMapperElementTypes.Concat_2006 == req.getElementType()) {
			return getGEFWrapper(new ConcatCreateCommand(req));
		}
		if (DataMapperElementTypes.Add_2012 == req.getElementType()) {
			return getGEFWrapper(new AddCreateCommand(req));
		}
		if (DataMapperElementTypes.Split_2007 == req.getElementType()) {
			return getGEFWrapper(new SplitCreateCommand(req));
		}
		if (DataMapperElementTypes.Constant_2008 == req.getElementType()) {
			return getGEFWrapper(new ConstantCreateCommand(req));
		}
		if (DataMapperElementTypes.LowerCase_2009 == req.getElementType()) {
			return getGEFWrapper(new LowerCaseCreateCommand(req));
		}
		if (DataMapperElementTypes.Contains_2010 == req.getElementType()) {
			return getGEFWrapper(new ContainsCreateCommand(req));
		}
		if (DataMapperElementTypes.UpperCase_2011 == req.getElementType()) {
			return getGEFWrapper(new UpperCaseCreateCommand(req));
		}
		if (DataMapperElementTypes.Multiply_2014 == req.getElementType()) {
			return getGEFWrapper(new MultiplyCreateCommand(req));
		}
		if (DataMapperElementTypes.Divide_2015 == req.getElementType()) {
			return getGEFWrapper(new DivideCreateCommand(req));
		}
		if (DataMapperElementTypes.Celi_2016 == req.getElementType()) {
			return getGEFWrapper(new CeliCreateCommand(req));
		}
		if (DataMapperElementTypes.Floor_2017 == req.getElementType()) {
			return getGEFWrapper(new FloorCreateCommand(req));
		}
		if (DataMapperElementTypes.Round_2018 == req.getElementType()) {
			return getGEFWrapper(new RoundCreateCommand(req));
		}
		if (DataMapperElementTypes.SetPrecision_2019 == req.getElementType()) {
			return getGEFWrapper(new SetPrecisionCreateCommand(req));
		}
		if (DataMapperElementTypes.AbsoluteValue_2020 == req.getElementType()) {
			return getGEFWrapper(new AbsoluteValueCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
