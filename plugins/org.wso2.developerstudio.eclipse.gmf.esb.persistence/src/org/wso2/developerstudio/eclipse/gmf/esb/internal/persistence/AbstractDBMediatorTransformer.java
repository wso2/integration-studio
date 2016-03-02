/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map.Entry;
import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.commons.datasource.DataSourceInformation;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.endpoints.Endpoint;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.apache.synapse.mediators.db.AbstractDBMediator;
import org.apache.synapse.mediators.db.Statement;
import org.apache.synapse.util.xpath.SynapseXPath;

/**
 * Transformer for AbstractDBMediator to be used for serialize DBLookup and
 * DBReport mediators
 * 
 */
public abstract class  AbstractDBMediatorTransformer extends AbstractEsbNodeTransformer {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
    public static final QName URL_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "url");
    static final QName DRIVER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "driver");
    static final QName USER_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "user");
    static final QName PASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "password");

    public static final QName DSNAME_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "dsName");
    static final QName ICCLASS_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "icClass");
	
	protected <T extends AbstractDBMediator> void transformDBMediator(T dbMediator,AbstractSqlExecutorMediator sqlExecutor){
		setCommonProperties(dbMediator, sqlExecutor);
		
		dbMediator.setDataSourceName(sqlExecutor.getConnectionDsName());
		DataSourceInformation dataSourceInfo=new DataSourceInformation();
		if (sqlExecutor.getConnectionType().equals(SqlExecutorConnectionType.DATA_SOURCE)) {
			dbMediator.setDataSourceName(sqlExecutor.getConnectionDsName());
			dbMediator.addDataSourceProperty(DSNAME_Q, sqlExecutor.getConnectionDsName());
			if (sqlExecutor.getConnectionDsType().equals(SqlExecutorDatasourceType.EXTERNAL)) {
				dbMediator.addDataSourceProperty(ICCLASS_Q, sqlExecutor.getConnectionDsInitialContext());
				dbMediator.addDataSourceProperty(URL_Q, sqlExecutor.getConnectionURL());
				dbMediator.addDataSourceProperty(USER_Q, sqlExecutor.getConnectionUsername());
				dbMediator.addDataSourceProperty(PASS_Q, sqlExecutor.getConnectionPassword());
				addDataSourceProperties(dbMediator,sqlExecutor);
			}
			
		} else {
			dbMediator.addDataSourceProperty(DRIVER_Q, sqlExecutor.getConnectionDbDriver());
			dbMediator.addDataSourceProperty(URL_Q, sqlExecutor.getConnectionURL());
			dbMediator.addDataSourceProperty(USER_Q, sqlExecutor.getConnectionUsername());
			dbMediator.addDataSourceProperty(PASS_Q, sqlExecutor.getConnectionPassword());
			addDataSourceProperties(dbMediator,sqlExecutor);
		}
		
		dbMediator.setDataSourceInformation(dataSourceInfo);
		
		for(SqlStatement sqlStatement : sqlExecutor.getSqlStatements()){
			Statement statement = new Statement(sqlStatement.getQueryString());
			for(SqlParameterDefinition param :sqlStatement.getParameters()){
				if(param.getValueType()==SqlParameterValueType.EXPRESSION){
					NamespacedProperty namespacedProperty = param.getValueExpression();
					SynapseXPath expression = null;
					try {
						expression = new SynapseXPath(namespacedProperty.getPropertyValue());
						for (Entry<String, String> entry : namespacedProperty.getNamespaces().entrySet()) {
							expression.addNamespace(entry.getKey(), entry.getValue());
						}
						statement.addParameter(null, expression, param.getDataType().getLiteral());
					} catch (JaxenException e) {
						log.warn("An unexpected error has occurred while getting xpath expression.. ignoring... ", e);
					}
				} else{
					statement.addParameter(param.getValueLiteral(), null, param.getDataType().getLiteral());
				}
			}
			for(SqlResultMapping resultMapping : sqlStatement.getResults()){
				statement.addResult(resultMapping.getPropertyName(), resultMapping.getColumnId());
			}
			dbMediator.addStatement(statement);
		}
		
		
	}
	
	private  <T extends AbstractDBMediator>  void addDataSourceProperties(T dbMediator,AbstractSqlExecutorMediator sqlExecutor){
		/* there are several setter method in DataSourceInformation class, but not required for serialization */
		
			if (!sqlExecutor.getPropertyAutocommit().equals(SqlExecutorBooleanValue.DEFAULT)) {
				dbMediator.addDataSourceProperty( "autocommit", sqlExecutor.getPropertyAutocommit().getLiteral());
			}
			
			if (!sqlExecutor.getPropertyIsolation().equals(SqlExecutorIsolationLevel.DEFAULT)) {
				dbMediator.addDataSourceProperty( "isolation", sqlExecutor.getPropertyIsolation().getLiteral());
			}
			
			if (sqlExecutor.getPropertyMaxactive() > -1) {
				dbMediator.addDataSourceProperty( "maxactive", Integer.toString(sqlExecutor.getPropertyMaxactive()));
			}
			
			if (sqlExecutor.getPropertyMaxidle() > -1) {
				dbMediator.addDataSourceProperty( "maxidle", Integer.toString(sqlExecutor.getPropertyMaxidle()));
			}
			
			if (sqlExecutor.getPropertyMaxopenstatements() > -1) {
				dbMediator.addDataSourceProperty( "maxopenstatements", Integer.toString(sqlExecutor.getPropertyMaxopenstatements()));
			}
			
			if (sqlExecutor.getPropertyMaxwait() > -1) {
				dbMediator.addDataSourceProperty( "maxwait", Integer.toString(sqlExecutor.getPropertyMaxwait()));
			}
			
			if (sqlExecutor.getPropertyMinidle() > -1) {
				dbMediator.addDataSourceProperty( "minidle", Integer.toString(sqlExecutor.getPropertyMinidle()));
			}
			
			if (!sqlExecutor.getPropertyPoolstatements().equals(SqlExecutorBooleanValue.DEFAULT)) {
				dbMediator.addDataSourceProperty( "poolstatements", sqlExecutor.getPropertyPoolstatements().getLiteral());
			}
			
			if (!sqlExecutor.getPropertyTestonborrow().equals(SqlExecutorBooleanValue.DEFAULT)) {
				dbMediator.addDataSourceProperty( "testonborrow", sqlExecutor.getPropertyTestonborrow().getLiteral());
			}
			
			if (!sqlExecutor.getPropertyTestwhileidle().equals(SqlExecutorBooleanValue.DEFAULT)) {
				dbMediator.addDataSourceProperty( "testwhileidle", sqlExecutor.getPropertyTestwhileidle().getLiteral());
			}
			
			if (!StringUtils.isBlank(sqlExecutor.getPropertyValidationquery())) {
				dbMediator.addDataSourceProperty( "validationquery", sqlExecutor.getPropertyValidationquery());
			}
			
			if (sqlExecutor.getPropertyInitialsize() > -1) {
				dbMediator.addDataSourceProperty( "initialsize", Integer.toString(sqlExecutor.getPropertyInitialsize()));
			}		
	}
	
	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {

	}

}
