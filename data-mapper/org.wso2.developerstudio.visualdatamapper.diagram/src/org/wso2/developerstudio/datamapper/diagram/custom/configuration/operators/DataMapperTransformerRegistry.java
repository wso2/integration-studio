package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operators;

import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.Equal;
import org.wso2.developerstudio.datamapper.LowerCase;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.UpperCase;

public class DataMapperTransformerRegistry {

	private static DataMapperTransformerRegistry singleton;

	/**
	 * Visual model type to transformers map.
	 */
	private Map<Class<?>, OperatorsTransformer> transformersMap;

	/**
	 * @return singleton instance.
	 */
	public static DataMapperTransformerRegistry getInstance() {
		if (null == singleton) {
			singleton = new DataMapperTransformerRegistry();
		}
		return singleton;
	}
	/**
	 * All config generation logics implemented class must map to relevant operator classes.
	 * 
	 */
	private DataMapperTransformerRegistry() {
		transformersMap = new HashMap<Class<?>, OperatorsTransformer>();
		addTransformer(Concat.class, new ConcatTransformer());
		addTransformer(Split.class, new SplitTransformer());
		addTransformer(LowerCase.class, new ToLowerCaseTransformer());
		addTransformer(UpperCase.class, new ToUpperCaseTransformer());
		addTransformer(Contains.class, new ContainsTransformer());
		addTransformer(Constant.class, new ConstantTransformer());

	}


	public <K extends Operator> void addTransformer(Class<K> visualModelClass,
			OperatorsTransformer transformer) {
		transformersMap.put(visualModelClass, transformer);
	}

	/**
	 * 
	 * @param operator operator object which needs to find relevant config generation object
	 * @return relevant config generation object
	 */
	public <K extends Operator> OperatorsTransformer getTransformer(K operator) {
		return transformersMap.get(operator.eClass().getInstanceClass());
	}
}
