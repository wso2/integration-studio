package org.wso2.developerstudio.datamapper.diagram.tree.generator;

import org.wso2.developerstudio.datamapper.diagram.tree.model.Tree;

public interface ITreeSchemaReader {

	public abstract Tree generateInputTree();

	public abstract Tree generateInputTreeFromFile(String path);

	/**
	 * @param schemaAvro schema that is used to parse to tree     
	 * @return
	 */
	public abstract Tree generateInputTreeFromSchema(TreeSchema schema);

	/* (non-Javadoc)
	 * @see org.wso2.developerstudio.datamapper.diagram.tree.generator.ITreeSchema#generateOutputTree()
	 */
	public abstract Tree generateOutputTree();

}