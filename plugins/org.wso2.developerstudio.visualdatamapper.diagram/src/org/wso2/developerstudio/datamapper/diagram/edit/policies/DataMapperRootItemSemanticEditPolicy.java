package org.wso2.developerstudio.datamapper.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ANDCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.AbsoluteValueCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.AddCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.AdvancedCustomFunctionCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.CeliCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.CloneCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.CompareCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ConcatCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ConstantCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ContainsCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.CustomFunctionCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.DivideCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.EndsWithCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.EqualCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.FloorCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.GlobalVariableCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.IfElseCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.InputCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.LowerCaseCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.MatchCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.MaxCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.MinCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.MultiplyCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.NOTCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ORCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.OutputCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.PropertiesCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ReplaceCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.RoundCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SetPrecisionCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SplitCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.StartsWithCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.StringLengthCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.StringToBooleanCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.StringToNumberCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SubstringCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.SubtractCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.ToStringCreateCommand;
import org.wso2.developerstudio.datamapper.diagram.edit.commands.TrimCreateCommand;
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
		if (DataMapperElementTypes.StringLength_2021 == req.getElementType()) {
			return getGEFWrapper(new StringLengthCreateCommand(req));
		}
		if (DataMapperElementTypes.StartsWith_2022 == req.getElementType()) {
			return getGEFWrapper(new StartsWithCreateCommand(req));
		}
		if (DataMapperElementTypes.EndsWith_2023 == req.getElementType()) {
			return getGEFWrapper(new EndsWithCreateCommand(req));
		}
		if (DataMapperElementTypes.Substring_2024 == req.getElementType()) {
			return getGEFWrapper(new SubstringCreateCommand(req));
		}
		if (DataMapperElementTypes.IfElse_2025 == req.getElementType()) {
			return getGEFWrapper(new IfElseCreateCommand(req));
		}
		if (DataMapperElementTypes.AND_2026 == req.getElementType()) {
			return getGEFWrapper(new ANDCreateCommand(req));
		}
		if (DataMapperElementTypes.OR_2027 == req.getElementType()) {
			return getGEFWrapper(new ORCreateCommand(req));
		}
		if (DataMapperElementTypes.NOT_2028 == req.getElementType()) {
			return getGEFWrapper(new NOTCreateCommand(req));
		}
		if (DataMapperElementTypes.Trim_2029 == req.getElementType()) {
			return getGEFWrapper(new TrimCreateCommand(req));
		}
		if (DataMapperElementTypes.Replace_2030 == req.getElementType()) {
			return getGEFWrapper(new ReplaceCreateCommand(req));
		}
		if (DataMapperElementTypes.Match_2031 == req.getElementType()) {
			return getGEFWrapper(new MatchCreateCommand(req));
		}
		if (DataMapperElementTypes.Min_2032 == req.getElementType()) {
			return getGEFWrapper(new MinCreateCommand(req));
		}
		if (DataMapperElementTypes.Max_2033 == req.getElementType()) {
			return getGEFWrapper(new MaxCreateCommand(req));
		}
		if (DataMapperElementTypes.CustomFunction_2034 == req.getElementType()) {
			return getGEFWrapper(new CustomFunctionCreateCommand(req));
		}
		if (DataMapperElementTypes.Properties_2035 == req.getElementType()) {
			return getGEFWrapper(new PropertiesCreateCommand(req));
		}
		if (DataMapperElementTypes.Compare_2036 == req.getElementType()) {
			return getGEFWrapper(new CompareCreateCommand(req));
		}
		if (DataMapperElementTypes.StringToNumber_2037 == req.getElementType()) {
			return getGEFWrapper(new StringToNumberCreateCommand(req));
		}
		if (DataMapperElementTypes.StringToBoolean_2038 == req.getElementType()) {
			return getGEFWrapper(new StringToBooleanCreateCommand(req));
		}
		if (DataMapperElementTypes.Clone_2039 == req.getElementType()) {
			return getGEFWrapper(new CloneCreateCommand(req));
		}
		if (DataMapperElementTypes.ToString_2040 == req.getElementType()) {
			return getGEFWrapper(new ToStringCreateCommand(req));
		}
		if (DataMapperElementTypes.GlobalVariable_2041 == req.getElementType()) {
			return getGEFWrapper(new GlobalVariableCreateCommand(req));
		}
		if (DataMapperElementTypes.AdvancedCustomFunction_2042 == req.getElementType()) {
			return getGEFWrapper(new AdvancedCustomFunctionCreateCommand(req));
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
