package org.wso2.developerstudio.eclipse.registry.core.internal.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Import;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.wsdl.extensions.schema.SchemaReference;

import org.wso2.developerstudio.eclipse.libraries.utils.WSDLUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.GARFileType;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IGARImportDependency;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class GARImportDependencyImpl implements IGARImportDependency {
	private boolean exclude=false;
	private URL source;
	private GARFileType type;
	private List<IGARImportDependency> schemaImports=new ArrayList<IGARImportDependency>();
	private List<IGARImportDependency> schemaIncludes=new ArrayList<IGARImportDependency>();
	private List<IGARImportDependency> wsdlImports=new ArrayList<IGARImportDependency>();
	private List<IGARImportDependency> policyImports=new ArrayList<IGARImportDependency>();
	
	private Map<IGARImportDependency,String> dependencyImportPaths=new HashMap<IGARImportDependency, String>();
	private Map<IGARImportDependency,Object> dependencyImportObject=new HashMap<IGARImportDependency, Object>();
	private boolean initialized=false;
	private Definition definition;
	private Schema schema;
	
	public GARImportDependencyImpl(URL source) {
		setSource(source);
	}
	
	public GARImportDependencyImpl(URL source, Definition definition) {
		setSource(source);
		setType(GARFileType.WSDL);
		setDefinition(definition);
	}
	
	public GARImportDependencyImpl(URL source, Schema schema) {
		setSource(source);
		setType(GARFileType.SCHEMA_IMPORTS);
		setSchema(schema);
	}
	
	public GARImportDependencyImpl(URL source, GARFileType type) {
		setSource(source);
		setType(type);
	}
	
	public boolean isExclude() {
		return exclude;
	}

	public void setExclude(boolean exclude) {
		this.exclude=exclude;
	}
	
	public IGARImportDependency[] getSchemaImports() throws Exception {
		initialize();
		return schemaImports.toArray(new IGARImportDependency[]{});
	}

	public URL getSource() {
		return source;
	}

	public String getSpecifiedSource(IGARImportDependency garImport) throws Exception {
		initialize();
		if (dependencyImportPaths.containsKey(garImport)){
			return dependencyImportPaths.get(garImport);
		}
		return null;
	}

	public GARFileType getType() {
		return type;
	}

	public IGARImportDependency[] getWSDLImports() throws Exception {
		initialize();
		return wsdlImports.toArray(new IGARImportDependency[]{});
	}

	public void setType(GARFileType type) {
		this.type = type;
	}

	public void setSource(URL source) {
		this.source = source;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public boolean isInitialized() {
		return initialized;
	}

	private void initialize() throws Exception{
		if (isInitialized()){
			return;
		}
		if (getType()==GARFileType.WSDL){
			retrieveImportsForWSDL();
		}else if (getType()==GARFileType.SCHEMA_IMPORTS){
			Map imports = getSchema().getImports();
			setupSchemaImportList(getParentURL(), imports);
		}
		setInitialized(true);
	}

	private void retrieveImportsForWSDL() throws Exception,
			MalformedURLException {
		URL parentURL = getParentURL();
		setupWSDLImportsFromWSDL(getDefinition(), parentURL);
		setupSchemaImportsFromWSDL(getDefinition(), parentURL);
		setupSchemaIncludesFromWSDL(getDefinition(), parentURL);
		setupPolicyImportsFromWSDL(getDefinition(),parentURL);
	}

	private URL getParentURL() throws MalformedURLException {
		URL parentURL = FileUtils.getParentURL(getSource());
		return parentURL;
	}

	private void setupPolicyImportsFromWSDL(Definition definition, URL parentURL) throws MalformedURLException{
		Map bindings = definition.getBindings();
		for (Object o : bindings.keySet()) {
			Object object = bindings.get(o);
			if (object instanceof Binding){
				Binding binding=(Binding)object;
				List extensibilityElements = binding.getExtensibilityElements();
				for (Object object2 : extensibilityElements) {
					ExtensibilityElement extensibilityElement=(ExtensibilityElement)object2;
					if (extensibilityElement.getElementType().getLocalPart().equalsIgnoreCase("PolicyReference")){
						if (extensibilityElement instanceof UnknownExtensibilityElement){
							UnknownExtensibilityElement u=(UnknownExtensibilityElement)extensibilityElement;
							String locationURI = u.getElement().getAttribute("URI");
							if (locationURI!=null){
								URL policyUrl = getDependencyURL(parentURL, locationURI);
								IGARImportDependency garImportDependency = new GARImportDependencyImpl(policyUrl, GARFileType.POLICY);
								addDependency(garImportDependency, policyImports, u, locationURI);
							}
						}
					}
				}
			}
		}
		
	}
	
	
	private void setupWSDLImportsFromWSDL(Definition definition, URL parentURL)
			throws MalformedURLException {
		Map wsdlImportMap = definition.getImports();
		for (Object o : wsdlImportMap.keySet()) {
			Object object = wsdlImportMap.get(o);
			if (object instanceof Iterable){
				Iterator iterator = ((Iterable)object).iterator();
				while(iterator.hasNext()){
					Object next = iterator.next();
					if (next instanceof Import){
						Import wsdlImport=(Import)next;
						String locationURI = wsdlImport.getLocationURI();
						if (locationURI!=null) {
							URL wsdlUrl = getDependencyURL(parentURL,locationURI);
							GARImportDependencyImpl garWSDLImportDependency = new GARImportDependencyImpl(wsdlUrl, wsdlImport.getDefinition());
							addDependency(garWSDLImportDependency,wsdlImports, wsdlImport, locationURI);
						}
					}
				}
			}
		}
	}

	private URL getDependencyURL(URL parentURL, String locationURI)
			throws MalformedURLException {
		URL url;
		try {
			url = new URL(locationURI);
		} catch (MalformedURLException e) {
			// The given location is an absolute location
			url = new URL(parentURL + "/"
					+ locationURI);
		}
		return url;
	}

	private void addDependency(IGARImportDependency garImportDependency, List<IGARImportDependency> dependencyList, Object importObject, String locationURI) {
		if (!isDependencyAlreadyAdded(garImportDependency.getSource())){
			dependencyList.add(garImportDependency);
			dependencyImportPaths.put(garImportDependency,locationURI);
			dependencyImportObject.put(garImportDependency, importObject);
		}
	}

	private void setupSchemaImportsFromWSDL(Definition definition, URL parentURL)
			throws MalformedURLException {
		List extensibilityElements = definition.getTypes().getExtensibilityElements();
		for (Object extensibilityElement : extensibilityElements) {
			if (extensibilityElement instanceof Schema){
				Schema s=(Schema)extensibilityElement;
				Map imports = s.getImports();
				setupSchemaImportList(parentURL, imports);
			}
		}
	}

	private void setupSchemaImportList(URL parentURL, Map imports)
			throws MalformedURLException {
		for (Object key : imports.keySet()) {
			Object object = imports.get(key);
			if (object instanceof Iterable){
				Iterable i=(Iterable)object;
				Iterator iterator = i.iterator();
				while(iterator.hasNext()){
					Object p=iterator.next();
					if (p instanceof SchemaImport) {
						SchemaImport si=(SchemaImport)p;
						String locationURI = si.getSchemaLocationURI();
						if (locationURI!=null) {
							URL schemaUrl = getDependencyURL(parentURL,locationURI);
							GARImportDependencyImpl garSchemaImportDependency = new GARImportDependencyImpl(schemaUrl, si.getReferencedSchema());
							addDependency(garSchemaImportDependency, schemaImports, si, locationURI);
						}
					}
				}
			}
		}
	}

	private void setupSchemaIncludesFromWSDL(Definition definition, URL parentURL) throws MalformedURLException {
		List extensibilityElements = definition.getTypes().getExtensibilityElements();
		for (Object extensibilityElement : extensibilityElements) {
			if (extensibilityElement instanceof Schema){
				Schema s=(Schema)extensibilityElement;
				List includes = s.getIncludes();
				for (Object include : includes) {
					if (include instanceof SchemaReference){
						SchemaReference schemaReference=(SchemaReference)include;
						String schemaLocationURI = schemaReference.getSchemaLocationURI();
						if (schemaLocationURI!=null){
							IGARImportDependency garImportDependencyImpl = new GARImportDependencyImpl(getDependencyURL(parentURL, schemaLocationURI), schemaReference.getReferencedSchema());
							addDependency(garImportDependencyImpl, schemaIncludes, schemaReference, schemaLocationURI);
						}
					}
				}
				
			}
		}
	}
	
//	private void setupSchemaIncludeList(URL parentURL, Map imports) throws MalformedURLException {
//		for (Object key : imports.keySet()) {
//			Object object = imports.get(key);
//			if (object instanceof Iterable){
//				Iterable i=(Iterable)object;
//				Iterator iterator = i.iterator();
//				while(iterator.hasNext()){
//					Object p=iterator.next();
//					if (p instanceof SchemaImport) {
//						SchemaImport si=(SchemaImport)p;
//						String locationURI = si.getSchemaLocationURI();
//						if (locationURI!=null) {
//							URL schemaUrl = getDependencyURL(parentURL,locationURI);
//							GARImportDependencyImpl garSchemaImportDependency = new GARImportDependencyImpl(schemaUrl, si.getReferencedSchema());
//							addDependency(garSchemaImportDependency, schemaImports, si, locationURI);
//						}
//					}
//				}
//			}
//		}
//	}
	
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	public Definition getDefinition() throws Exception {
		if (definition==null) {
			setDefinition(WSDLUtils.readWSDL(getSource()));
		}
		return definition;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public Schema getSchema() {
		return schema;
	}

	public File toFile(File baseLocation, boolean isRoot) throws Exception {
		File parentLocation=baseLocation;
		if (!isRoot){
			parentLocation=getImportSaveLocation(baseLocation);
		}
		Map<String,String> locationReplacements=new HashMap<String, String>();
		for (IGARImportDependency dependency : dependencyImportObject.keySet()) {
			String newLocationURI;
			if (dependency.isExclude()){
				newLocationURI=dependency.getSource().toString();
			}else{
				File dependencyImportPath = dependency.toFile(baseLocation, false);
				String relativePath = FileUtils.getRelativePath(parentLocation, dependencyImportPath);
				newLocationURI=relativePath.replace(File.pathSeparatorChar, '/');
			}
			Object object = dependencyImportObject.get(dependency);
			if (object instanceof SchemaImport){
				locationReplacements.put("schemaLocation=\""+getSpecifiedSource(dependency)+"\"", "schemaLocation=\""+newLocationURI+"\"");
			}else if (object instanceof SchemaReference){
				locationReplacements.put("schemaLocation=\""+getSpecifiedSource(dependency)+"\"", "schemaLocation=\""+newLocationURI+"\"");
			}else if (object instanceof Import){
				Import wsdlImport=(Import)object;
				wsdlImport.setLocationURI(newLocationURI);
			} else if (object instanceof UnknownExtensibilityElement){
				locationReplacements.put("URI=\""+getSpecifiedSource(dependency)+"\"", "URI=\""+newLocationURI+"\"");
			}
		}
		
		String fileContent = getFileContent();
		
		if (fileContent==null){
			return null;
		}else{
			for (String key : locationReplacements.keySet()) {
				fileContent=fileContent.replaceAll(Pattern.quote(key), locationReplacements.get(key));
			}
			File importFile = createUniqueFile(parentLocation, fileContent, isRoot);
			return importFile;
		}
	}

	private String getFileContent() throws WSDLException, Exception,
			IOException {
		String fileContent=null;
		switch (getType()){
			case WSDL:
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				WSDLUtils.writeWSDL(definition, outputStream);
				fileContent=outputStream.toString();
				break;
			case SCHEMA_IMPORTS:case SCHEMA_INCLUDES:
				fileContent=XMLUtil.getSchemaString(getSchema());
				break;
			case POLICY:
				fileContent=FileUtils.getContentAsString(getSource());
		}
		return fileContent;
	}

	private File createUniqueFile(File parentLocation, String content, boolean isRoot) throws IOException {
		String extension = getExtension();
		String fileName = FileUtils.getFileName(getSource());
		if (fileName.endsWith(extension)){
			fileName=FileUtils.getResourceFileName(fileName);
		}
		File importFile=new File(parentLocation,fileName+extension);
		int i=2;
		while(importFile.exists()){
			String contentAsString = FileUtils.getContentAsString(importFile);
			if (contentAsString.equals(content)){
				break;
			}
			importFile=new File(parentLocation,fileName+i+extension);
			i++;
		}
		if (!importFile.exists()){
			importFile.getParentFile().mkdirs();
			FileUtils.writeContent(importFile, content);
		}
		return importFile;
	}
	
	private String getExtension(){
		switch (getType()){
			case WSDL:
				return ".wsdl"; 
			case SCHEMA_IMPORTS:
				return ".xsd"; 
			case SCHEMA_INCLUDES:
				return ".xsd"; 
			case POLICY:
				return ".xml"; 
		}
		return null;
	}
	
	private File getImportSaveLocation(File baseLocation){
		switch (getType()){
			case WSDL:
				return new File(baseLocation,WSDL_LOCATION); 
			case SCHEMA_IMPORTS:
				return new File(baseLocation,SCHEMA_LOCATION);
			case SCHEMA_INCLUDES:
				return new File(baseLocation,SCHEMA_LOCATION);
			case POLICY:
				return new File(baseLocation,POLICY_LOCATION);
		}
		return null;
	}

	public IGARImportDependency[] getPolicyImports() throws Exception {
		initialize();
		return policyImports.toArray(new IGARImportDependency[]{});
	}

	public IGARImportDependency[] getSchemaIncludes() throws Exception {
		initialize();
		return schemaIncludes.toArray(new IGARImportDependency[]{});
	}
	
	private boolean isDependencyAlreadyAdded(URL url){
		for (IGARImportDependency garDependency : dependencyImportPaths.keySet()) {
			if (garDependency.getSource().toString().equals(url.toString())){
				return true;
			}
		}
		return false;
	}
}
