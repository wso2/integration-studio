package org.wso2.developerstudio.eclipse.artifact.dataservice.model;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class DataServiceModel extends ProjectDataModel {
	
	private String serviceName;
	private String serviceGroup;
	private String serviceNS;
	private String serviceDescription;
	private String dataSourceId;
	
	//configuration 
	private RdbmsConfig rdbmsConfig;
	private CsvConfig csvConfig;
	private JndiConfig jndiConfig;
	private GoogleSpreadsheetConfig gSpreadsheetConfig;
	private WebDataSourceConfig webDataSourceConfig;
	private ExcelConfig excelConfig;
	private RdfConfig rdfConfig; 
	private CarbonDataConfig carbonDataConfig;
	private DataSourceConfig dataSourceConfig;
	
	public DataServiceModel() {
		rdbmsConfig = new RdbmsConfig();
		csvConfig = new CsvConfig();
		jndiConfig = new JndiConfig();
		gSpreadsheetConfig = new GoogleSpreadsheetConfig();
		webDataSourceConfig = new WebDataSourceConfig();
		excelConfig = new ExcelConfig();
		rdfConfig = new RdfConfig(); 
		carbonDataConfig = new CarbonDataConfig();
	}

	 
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_NAME)) {
			modelPropertyValue = getServiceName();
		} else if (key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_GROUP)) {
			modelPropertyValue = getServiceGroup();
		} else if (key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_NS)) {
			modelPropertyValue = getServiceNS();
		} else if (key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_DESCRIPTION)) {
			modelPropertyValue = getServiceDescription();
		}
		return modelPropertyValue;
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				setProjectName(ProjectUtils.fileNameWithoutExtension(getImportFile().getName()));
			}
		}
		else if(key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_NAME)){
			setServiceName(data.toString());
		} else if(key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_GROUP)){
			setServiceGroup(data.toString());		
		} else if(key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_NS)){
			setServiceNS(data.toString())	;	
		} else if(key.equals(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_DESCRIPTION)){
			setServiceDescription(data.toString());
		} 
		return returnValue;
	}
	
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	
	public String getServiceName(){
		return serviceName;
	}
	
	public void setServiceGroup(String serviceGroup){
		this.serviceGroup = serviceGroup;
	}
	
	public String getServiceGroup(){
		return serviceGroup;
	}
	
	public void setServiceNS(String serviceNS){
		this.serviceNS = serviceNS;
	}
	
	public String getServiceNS(){
		return serviceNS;
	}
	
	public void setServiceDescription(String serviceDescription){
		this.serviceDescription = serviceDescription;
	}
	
	public String getServiceDescription(){
		return serviceDescription;
	}
	
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getDataSourceId() {
		return dataSourceId;
	}

	public RdbmsConfig getRdbmsConfig(){
		return rdbmsConfig;
	}

	public CsvConfig getCsvConfig(){
		return csvConfig;
	}

	public JndiConfig getJndiConfig(){
		return jndiConfig;
	}

	public GoogleSpreadsheetConfig getGoogleSpreadsheetConfig(){
		return gSpreadsheetConfig;
	}
	
	public WebDataSourceConfig getWebDataSourceConfig(){
		return webDataSourceConfig;
	}
	
	public  ExcelConfig getExcelConfig() {
		return excelConfig;
	}

	public RdfConfig getRdfConfig() {
		return rdfConfig;
	}

	public CarbonDataConfig getCarbonDataConfig() {
		return carbonDataConfig;
	}

	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
		this.dataSourceConfig = dataSourceConfig;
	}
	
	public void setDataSourceConfig(int dataSource) {
		switch(dataSource){
		case 0:
			setDataSourceConfig(getRdbmsConfig());
			break;
		case 1:
			setDataSourceConfig(getCsvConfig());
			break;
		case 2:
			setDataSourceConfig(getExcelConfig());
			break;
		case 3:
			setDataSourceConfig(getRdfConfig());
			break;
		case 4:
			setDataSourceConfig(getJndiConfig());
			break;
		case 5:
			setDataSourceConfig(getGoogleSpreadsheetConfig());
			break;
		case 6:
			setDataSourceConfig(getCarbonDataConfig());
			break;
		case 7:
			setDataSourceConfig(getWebDataSourceConfig());
			break;
		}
	}

	public DataSourceConfig getDataSourceConfig() {
		return dataSourceConfig;
	}

	public static class RdbmsConfig implements DataSourceConfig{
		private LinkedHashMap<String,String> config;
		private boolean xaDs;
		private String driverClass;
		private String xaDsClass;
		private String jdbcUrl;
		private String jdbcUser;
		private String jdbcPassword;
		
		public boolean isXaDs() {
			return xaDs;
		}

		public void setXaDs(boolean xaDs) {
			this.xaDs = xaDs;
		}

		public String getDriverClass() {
			return driverClass;
		}

		public void setDriverClass(String driverClass) {
			this.driverClass = driverClass;
		}

		public String getXaDsClass() {
			return xaDsClass;
		}

		public void setXaDsClass(String xaDsClass) {
			this.xaDsClass = xaDsClass;
		}

		public String getJdbcUrl() {
			return jdbcUrl;
		}

		public void setJdbcUrl(String jdbcUrl) {
			this.jdbcUrl = jdbcUrl;
		}

		public String getJdbcUser() {
			return jdbcUser;
		}

		public void setJdbcUser(String jdbcUser) {
			this.jdbcUser = jdbcUser;
		}

		public String getJdbcPassword() {
			return jdbcPassword;
		}

		public void setJdbcPassword(String jdbcPassword) {
			this.jdbcPassword = jdbcPassword;
		}
		
		public LinkedHashMap<String,String> getConfig(){
			config= new LinkedHashMap<String,String>();
			if(!isXaDs()){
			config.put("org.wso2.ws.dataservice.user",getJdbcUser());
			config.put("org.wso2.ws.dataservice.password",getJdbcPassword());
			config.put("org.wso2.ws.dataservice.protocol",getJdbcUrl());
			config.put("org.wso2.ws.dataservice.driver",getDriverClass());
		//	Fixing TOOLS-1000
		//	config.put("org.wso2.ws.dataservice.minpoolsize","");
		//	config.put("org.wso2.ws.dataservice.minpoolsize","");
		//	config.put("org.wso2.ws.dataservice.validation_query","");
			} else {
				config.put("org.wso2.ws.dataservice.xa_datasource_class",getXaDsClass());	
				String xaProperties = "\n";
				xaProperties+= "\t\t\t<property name=\"User\">" + getJdbcUser() + "</property>\n";
				xaProperties+= "\t\t\t<property name=\"Password\">" + getJdbcPassword() + "</property>\n";
				xaProperties+= "\t\t\t<property name=\"URL\">" + getJdbcUrl() +"</property>\n";
				config.put("org.wso2.ws.dataservice.xa_datasource_properties",xaProperties);
				}
			return config;
		}
	}
	
	public static class CsvConfig implements DataSourceConfig{
		private LinkedHashMap<String,String>  config;
		private String csvFileLocation;
		private String columnSeperator;
		private int startReadingFromRow;
		private int maxRowsToRead;
		private boolean containsColumnHeaderRow;
		
		public LinkedHashMap<String,String>  getConfig(){
			config = new LinkedHashMap<String, String>();
			config.put("csv_datasource", getCsvFileLocation());
			config.put("csv_columnseperator", getColumnSeperator());
			config.put("csv_startingrow", String.valueOf(getStartReadingFromRow()));
			config.put("csv_maxrowcount", String.valueOf(getMaxRowsToRead()));
			config.put("csv_hasheader", (isContainsColumnHeaderRow())?"true":"false");
			return config;
		}

		public String getCsvFileLocation() {
			return csvFileLocation;
		}

		public void setCsvFileLocation(String csvFileLocation) {
			this.csvFileLocation = csvFileLocation;
		}

		public String getColumnSeperator() {
			return columnSeperator;
		}

		public void setColumnSeperator(String columnSeperator) {
			this.columnSeperator = columnSeperator;
		}

		public int getStartReadingFromRow() {
			return startReadingFromRow;
		}

		public void setStartReadingFromRow(int startReadingFromRow) {
			this.startReadingFromRow = startReadingFromRow;
		}

		public int getMaxRowsToRead() {
			return maxRowsToRead;
		}

		public void setMaxRowsToRead(int maxRowsToRead) {
			this.maxRowsToRead = maxRowsToRead;
		}

		public boolean isContainsColumnHeaderRow() {
			return containsColumnHeaderRow;
		}

		public void setContainsColumnHeaderRow(boolean containsColumnHeaderRow) {
			this.containsColumnHeaderRow = containsColumnHeaderRow;
		}
	}
	
	public static class JndiConfig implements DataSourceConfig{
		private LinkedHashMap<String,String>  config;
		private String jndiContextClass;
		private String provideUrl;
		private String resourceName;
		private String password;
		
		public String getJndiContextClass() {
			return jndiContextClass;
		}

		public void setJndiContextClass(String jndiContextClass) {
			this.jndiContextClass = jndiContextClass;
		}

		public String getProvideUrl() {
			return provideUrl;
		}

		public void setProvideUrl(String provideUrl) {
			this.provideUrl = provideUrl;
		}

		public String getResourceName() {
			return resourceName;
		}

		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public LinkedHashMap<String,String>  getConfig(){
			config = new LinkedHashMap<String, String>();
			config.put("jndi_context_class", getJndiContextClass());
			config.put("jndi_provider_url", getProvideUrl());
			config.put("jndi_resource_name", getResourceName());
			config.put("jndi_password", getPassword());
			return config;
		}
	}
	
	public static class GoogleSpreadsheetConfig implements DataSourceConfig{
		private LinkedHashMap<String,String>  config;
		private String spreadsheetURL;
		private boolean publicVisible;
		private String userName;
		private String password;
		
		public String getSpreadsheetURL() {
			return spreadsheetURL;
		}

		public void setSpreadsheetURL(String spreadsheetURL) {
			this.spreadsheetURL = spreadsheetURL;
		}

		public boolean isPublicVisible() {
			return publicVisible;
		}

		public void setPublicVisible(boolean publicVisible) {
			this.publicVisible = publicVisible;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public LinkedHashMap<String,String>  getConfig(){
			config = new LinkedHashMap<String, String>();
			config.put("gspread_datasource", getSpreadsheetURL());
			if(!isPublicVisible()){
				config.put("gspread_visibility", "private");
				config.put("gspread_username", getUserName());
				config.put("gspread_password", getPassword());
			}
			else{
				config.put("gspread_visibility", "public");
			}
			
			return config;
		}
	}
	
	public static class ExcelConfig implements DataSourceConfig{
		private LinkedHashMap<String,String>  config;
		private String excelFileLocation;

		public void setExcelFileLocation(String excelFileLocation){
			this.excelFileLocation = excelFileLocation;
		}

		public String getExcelFileLocation(){
			return excelFileLocation;
		}
		
		public LinkedHashMap<String,String>  getConfig(){
			config = new LinkedHashMap<String, String>();
			config.put("excel_datasource", getExcelFileLocation());
			return config;
		}
	}
	
	public static class RdfConfig implements DataSourceConfig {
		private LinkedHashMap<String, String> config;
		private String rdfFileLocation;

		public void setRdfFileLocation(String rdfFileLocation) {
			this.rdfFileLocation = rdfFileLocation;
		}

		public String getRdfFileLocation() {
			return rdfFileLocation;
		}

		public LinkedHashMap<String, String> getConfig() {
			config = new LinkedHashMap<String, String>();
			config.put("rdf_datasource", getRdfFileLocation());
			return config;
		}
	}

	public static class CarbonDataConfig implements DataSourceConfig {
		private LinkedHashMap<String, String> config;
		private String carbonDataSourceName;

		public void setCarbonDataSourceName(String carbonDataSourceName) {
			this.carbonDataSourceName = carbonDataSourceName;
		}

		public String getCarbonDataSourceName() {
			return carbonDataSourceName;
		}

		public LinkedHashMap<String, String> getConfig() {
			config = new LinkedHashMap<String, String>();
			config.put("carbon_datasource_name", getCarbonDataSourceName());
			return config;
		}
	}
	
	public static class WebDataSourceConfig implements DataSourceConfig{
		private LinkedHashMap<String,String>  config;
		private boolean inlineConfig;
		private String webConfigPath;
		private String webConfigInlineText;
		
		public boolean isInlineConfig() {
			return inlineConfig;
		}

		public void setInlineConfig(boolean inlineConfig) {
			this.inlineConfig = inlineConfig;
		}

		public String getWebConfigPath() {
			return webConfigPath;
		}

		public void setWebConfigPath(String webConfigPath) {
			this.webConfigPath = webConfigPath;
		}

		public String getWebConfigInlineText() {
			return webConfigInlineText;
		}

		public void setWebConfigInlineText(String webConfigInlineText) {
			this.webConfigInlineText = webConfigInlineText;
		}

		public LinkedHashMap<String,String>  getConfig(){
			config = new LinkedHashMap<String, String>();
			config.put("web_harvest_config", isInlineConfig()?getWebConfigInlineText():getWebConfigPath());
			return config;
		}
	}
	
	public interface DataSourceConfig{
		public LinkedHashMap<String,String>  getConfig();
	}
	
}
