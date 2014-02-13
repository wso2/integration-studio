package org.wso2.datamapper.core;

import java.util.StringTokenizer;

import org.antlr.v4.runtime.misc.NotNull;
import org.wso2.datamapper.model.ConfigDataModel;
import org.wso2.datamapper.model.OutputDataModel;
import org.wso2.datamapper.parsers.MappingBaseListener;
import org.wso2.datamapper.parsers.MappingParser.ArgContext;
import org.wso2.datamapper.parsers.MappingParser.DefelementContext;
import org.wso2.datamapper.parsers.MappingParser.DeftypeContext;
import org.wso2.datamapper.parsers.MappingParser.FuncidContext;
import org.wso2.datamapper.parsers.MappingParser.OutputelementContext;
import org.wso2.datamapper.parsers.MappingParser.ValueContext;

public class ConfigModelGenerator extends MappingBaseListener{
	
	private ConfigDataModel configModel;
	private OutputDataModel outDataModel;
	
	public ConfigModelGenerator(){
		this.configModel = new ConfigDataModel();
	}
	
	@Override
	public void exitDeftype(@NotNull DeftypeContext ctx) {
		StringTokenizer st = new StringTokenizer(ctx.getText(),"->");

		while (st.hasMoreTokens()) {
			this.configModel.setInputDatatype("/"+st.nextToken().replace(".", "/"));
			this.configModel.setOutputdataType("/"+st.nextToken().replace(".", "/"));
		}
	}

	@Override
	public void enterOutputelement(@NotNull OutputelementContext ctx) {
		this.outDataModel = new OutputDataModel();
		this.outDataModel.setOutputElement(ctx.getText());
	}

	@Override
	public void exitDefelement(@NotNull DefelementContext ctx) {
		this.configModel.addOutDataModel(this.outDataModel);
		this.configModel.setOutDataModel(this.outDataModel);
	}

	@Override
	public void exitArg(@NotNull ArgContext ctx) {
		this.outDataModel.addArg(ctx.getText());
	}

	@Override
	public void enterFuncid(@NotNull FuncidContext ctx) {
		this.outDataModel.setFunction(ctx.getText());
	}

	public ConfigDataModel getConfigModel() {
		return configModel;
	}
	
}
