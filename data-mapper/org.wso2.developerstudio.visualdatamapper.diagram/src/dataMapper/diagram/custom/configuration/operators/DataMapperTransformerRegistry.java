package dataMapper.diagram.custom.configuration.operators;

import java.util.HashMap;
import java.util.Map;

import dataMapper.Concat;
import dataMapper.LowerCase;
import dataMapper.Operator;
import dataMapper.Split;

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

	private DataMapperTransformerRegistry() {
		transformersMap = new HashMap<Class<?>, OperatorsTransformer>();
		addTransformer(Concat.class, new ConcatTransform());
		addTransformer(Split.class, new SplitTransform());
		addTransformer(LowerCase.class, new ToLowerCaseTransform());

	}

	public <K extends Operator> void addTransformer(Class<K> visualModelClass,
			OperatorsTransformer transformer) {
		transformersMap.put(visualModelClass, transformer);
	}

	public <K extends Operator> OperatorsTransformer getTransformer(K operator) {
		return transformersMap.get(operator.eClass().getInstanceClass());
	}
}
