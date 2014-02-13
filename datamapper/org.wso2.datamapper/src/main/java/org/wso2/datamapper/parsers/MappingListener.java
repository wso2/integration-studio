// Generated from Mapping.g4 by ANTLR 4.1

  package org.wso2.datamapper.parsers;
  import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MappingParser}.
 */
public interface MappingListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MappingParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull MappingParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull MappingParser.ArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#deftype}.
	 * @param ctx the parse tree
	 */
	void enterDeftype(@NotNull MappingParser.DeftypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#deftype}.
	 * @param ctx the parse tree
	 */
	void exitDeftype(@NotNull MappingParser.DeftypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull MappingParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull MappingParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#varid}.
	 * @param ctx the parse tree
	 */
	void enterVarid(@NotNull MappingParser.VaridContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#varid}.
	 * @param ctx the parse tree
	 */
	void exitVarid(@NotNull MappingParser.VaridContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull MappingParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull MappingParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#outputelement}.
	 * @param ctx the parse tree
	 */
	void enterOutputelement(@NotNull MappingParser.OutputelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#outputelement}.
	 * @param ctx the parse tree
	 */
	void exitOutputelement(@NotNull MappingParser.OutputelementContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#funcid}.
	 * @param ctx the parse tree
	 */
	void enterFuncid(@NotNull MappingParser.FuncidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#funcid}.
	 * @param ctx the parse tree
	 */
	void exitFuncid(@NotNull MappingParser.FuncidContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#defelement}.
	 * @param ctx the parse tree
	 */
	void enterDefelement(@NotNull MappingParser.DefelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#defelement}.
	 * @param ctx the parse tree
	 */
	void exitDefelement(@NotNull MappingParser.DefelementContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterStatment(@NotNull MappingParser.StatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitStatment(@NotNull MappingParser.StatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link MappingParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull MappingParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MappingParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull MappingParser.FunctionContext ctx);
}