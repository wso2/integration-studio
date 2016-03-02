package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.sql.Types;

import org.apache.synapse.mediators.db.Statement;
import javax.xml.namespace.QName;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.db.AbstractDBMediator;
import org.apache.synapse.mediators.db.Statement.Parameter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public abstract class AbstractDBMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, AbstractSqlExecutorMediator>{
	
    public static final QName URL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "url");
    static final QName DRIVER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "driver");
    static final QName USER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "user");
    static final QName PASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "password");
    public static final QName DSNAME_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "dsName");
    static final QName ICCLASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "icClass");
	
	
	protected <T extends AbstractDBMediator> void deserializeDBMediator(T dbMediator,AbstractSqlExecutorMediator sqlExecutor){	
		setCommonProperties(dbMediator, sqlExecutor);
		
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME, dbMediator.getDataSourceProps().get(DSNAME_Q));
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL, dbMediator.getDataSourceProps().get(URL_Q));
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME, dbMediator.getDataSourceProps().get(USER_Q));
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD, dbMediator.getDataSourceProps().get(PASS_Q));
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER, dbMediator.getDataSourceProps().get(DRIVER_Q));
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT, dbMediator.getDataSourceProps().get(ICCLASS_Q));		
		
		if(dbMediator.getDataSourceProps().get(DRIVER_Q)!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE, SqlExecutorConnectionType.DB_CONNECTION);
			addDataSourceProperties(dbMediator,sqlExecutor);
		}else{
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE, SqlExecutorConnectionType.DATA_SOURCE);
			if(dbMediator.getDataSourceProps().get(ICCLASS_Q)!=null){
				executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE, SqlExecutorDatasourceType.EXTERNAL);
				addDataSourceProperties(dbMediator,sqlExecutor);
			}else{
				executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE, SqlExecutorDatasourceType.CARBON);
			}
		}
		
		EList<SqlStatement> sqlStatements=new BasicEList<SqlStatement>();
		for(Statement statement: dbMediator.getStatementList()){
			SqlStatement sqlStatement=EsbFactory.eINSTANCE.createSqlStatement();
			sqlStatement.setQueryString(statement.getRawStatement());
			
			for(Parameter parameter: statement.getParameters()){
				SqlParameterDefinition sqlParameterDefinition =EsbFactory.eINSTANCE.createSqlParameterDefinition();
				if(parameter.getXpath()!=null){
					sqlParameterDefinition.setValueExpression(createNamespacedProperty(parameter.getXpath()));
					sqlParameterDefinition.setValueType(SqlParameterValueType.EXPRESSION);
				}else {
					sqlParameterDefinition.setValueLiteral(parameter.getPropertyName());
					sqlParameterDefinition.setValueType(SqlParameterValueType.LITERAL);
				}
				
				if(parameter.getType()==Types.CHAR){
					sqlParameterDefinition.setDataType(SqlParameterDataType.CHAR);
				}else if(parameter.getType()==Types.VARCHAR){
					sqlParameterDefinition.setDataType(SqlParameterDataType.VARCHAR);
				}else if(parameter.getType()==Types.LONGNVARCHAR){
					sqlParameterDefinition.setDataType(SqlParameterDataType.LONGVARCHAR);
				}else if(parameter.getType()==Types.NUMERIC){
					sqlParameterDefinition.setDataType(SqlParameterDataType.NUMERIC);
				}else if(parameter.getType()==Types.DECIMAL){
					sqlParameterDefinition.setDataType(SqlParameterDataType.DECIMAL);
				}else if(parameter.getType()==Types.BIT){
					sqlParameterDefinition.setDataType(SqlParameterDataType.BIT);
				}else if(parameter.getType()==Types.TINYINT){
					sqlParameterDefinition.setDataType(SqlParameterDataType.TINYINT);
				}else if(parameter.getType()==Types.SMALLINT){
					sqlParameterDefinition.setDataType(SqlParameterDataType.SMALLINT);
				}else if(parameter.getType()==Types.INTEGER){
					sqlParameterDefinition.setDataType(SqlParameterDataType.INTEGER);
				}else if(parameter.getType()==Types.BIGINT){
					sqlParameterDefinition.setDataType(SqlParameterDataType.BIGINT);
				}else if(parameter.getType()==Types.REAL){
					sqlParameterDefinition.setDataType(SqlParameterDataType.REAL);
				}else if(parameter.getType()==Types.FLOAT){
					sqlParameterDefinition.setDataType(SqlParameterDataType.FLOAT);
				}else if(parameter.getType()==Types.DOUBLE){
					sqlParameterDefinition.setDataType(SqlParameterDataType.DOUBLE);
				}else if(parameter.getType()==Types.DATE){
					sqlParameterDefinition.setDataType(SqlParameterDataType.DATE);
				}else if(parameter.getType()==Types.TIME){
					sqlParameterDefinition.setDataType(SqlParameterDataType.TIME);
				}else if(parameter.getType()==Types.TIMESTAMP){
					sqlParameterDefinition.setDataType(SqlParameterDataType.TIMESTAMP);
				}
				
				sqlStatement.getParameters().add(sqlParameterDefinition);
			}
			
			for(String key:statement.getResultsMap().keySet()){
				SqlResultMapping sqlResultMapping=EsbFactory.eINSTANCE.createSqlResultMapping();
				sqlResultMapping.setColumnId(statement.getResultsMap().get(key));
				sqlResultMapping.setPropertyName(key);
				sqlStatement.getResults().add(sqlResultMapping);
			}
			
			sqlStatements.add(sqlStatement);
		}
		
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS, sqlStatements);		
	}
	
	private  <T extends AbstractDBMediator>  void addDataSourceProperties(T dbMediator,AbstractSqlExecutorMediator sqlExecutor){
	
		if(dbMediator.getDataSourceProps().get("autocommit")==null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT, SqlExecutorBooleanValue.DEFAULT);
		}else if(SqlExecutorBooleanValue.FALSE.getLiteral().equals(dbMediator.getDataSourceProps().get("autocommit"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT, SqlExecutorBooleanValue.FALSE);
		}else if(SqlExecutorBooleanValue.TRUE.getLiteral().equals(dbMediator.getDataSourceProps().get("autocommit"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT, SqlExecutorBooleanValue.TRUE);
		}
		
		if(dbMediator.getDataSourceProps().get("isolation")==null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.DEFAULT);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_NONE.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_NONE);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_READ_COMMITTED.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_READ_COMMITTED);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_REPEATABLE_READ.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_REPEATABLE_READ);
		}else if(SqlExecutorIsolationLevel.TRANSACTION_SERIALIZABLE.getLiteral().equals(dbMediator.getDataSourceProps().get("isolation"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, SqlExecutorIsolationLevel.TRANSACTION_SERIALIZABLE);
		}
		
		if(dbMediator.getDataSourceProps().get("maxactive")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE, Integer.parseInt(dbMediator.getDataSourceProps().get("maxactive")));
		}
		if(dbMediator.getDataSourceProps().get("maxidle")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE, Integer.parseInt(dbMediator.getDataSourceProps().get("maxidle")));
		}
		if(dbMediator.getDataSourceProps().get("maxopenstatements")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS, Integer.parseInt(dbMediator.getDataSourceProps().get("maxopenstatements")));
		}
		if(dbMediator.getDataSourceProps().get("maxwait")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT, Integer.parseInt(dbMediator.getDataSourceProps().get("maxwait")));
		}
		if(dbMediator.getDataSourceProps().get("minidle")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE, Integer.parseInt(dbMediator.getDataSourceProps().get("minidle")));
		}
		
		
		if(dbMediator.getDataSourceProps().get("poolstatements")==null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS, SqlExecutorBooleanValue.DEFAULT);
		}else if(SqlExecutorBooleanValue.FALSE.getLiteral().equals(dbMediator.getDataSourceProps().get("poolstatements"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS, SqlExecutorBooleanValue.FALSE);
		}else if(SqlExecutorBooleanValue.TRUE.getLiteral().equals(dbMediator.getDataSourceProps().get("poolstatements"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS, SqlExecutorBooleanValue.TRUE);
		}
		
		if(dbMediator.getDataSourceProps().get("testonborrow")==null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW, SqlExecutorBooleanValue.DEFAULT);
		}else if(SqlExecutorBooleanValue.FALSE.getLiteral().equals(dbMediator.getDataSourceProps().get("testonborrow"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW, SqlExecutorBooleanValue.FALSE);
		}else if(SqlExecutorBooleanValue.TRUE.getLiteral().equals(dbMediator.getDataSourceProps().get("testonborrow"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW, SqlExecutorBooleanValue.TRUE);
		}
		
		if(dbMediator.getDataSourceProps().get("testwhileidle")==null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE, SqlExecutorBooleanValue.DEFAULT);
		}else if(SqlExecutorBooleanValue.FALSE.getLiteral().equals(dbMediator.getDataSourceProps().get("testwhileidle"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE, SqlExecutorBooleanValue.FALSE);
		}else if(SqlExecutorBooleanValue.TRUE.getLiteral().equals(dbMediator.getDataSourceProps().get("testwhileidle"))){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE, SqlExecutorBooleanValue.TRUE);
		}
		
		executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY, dbMediator.getDataSourceProps().get("validationquery"));
		if(dbMediator.getDataSourceProps().get("initialsize")!=null){
			executeSetValueCommand(ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE, Integer.parseInt(dbMediator.getDataSourceProps().get("initialsize")));
		}

	}
	

}
