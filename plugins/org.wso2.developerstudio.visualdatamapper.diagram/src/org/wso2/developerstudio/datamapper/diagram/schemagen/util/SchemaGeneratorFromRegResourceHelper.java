package org.wso2.developerstudio.datamapper.diagram.schemagen.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.action.Messages;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;

public class SchemaGeneratorFromRegResourceHelper {
	private static final String FILE_NAME_VALUE = "tempSchemaContnt";
	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry"; //$NON-NLS-1$
	private static final String C_REG_PATH_PREFIX = "/_system/config/"; //$NON-NLS-1$
	private static final String ERROR_MSG_HEADER = Messages.SchemaKeyEditorDialog_ErrorMsgHeader;
	private static final String REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_RegistryBrowser;
	private static final String SELECT_REGISTRY_RESOURCE = Messages.SchemaKeyEditorDialog_SelectRegistryResource;
	private static final String TEMP_REG_RESOURCE_LOC = "tempRegRrsourceGenLocation";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";

	private static final String ERROR_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ErrorRegistryURL;
	private static final String REASON_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ReasonRegistryURL;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	//TODO add a hashmap with file extensions for the 
	public static String getSchemaContent(FileType option) {
		final String TEMP_OUTPUT = System.getProperty(JAVA_IO_TMPDIR) + File.separator + TEMP_REG_RESOURCE_LOC;
		FileType fileType = null;
		IRegistryData selectedPathData = null;
		ISchemaGenerator schemaGenerator = null;
		String schemaContent = null;
		File outputFile = null;
		String FILE_NAME = null;
		try {
			
			IRegistryConnection[] registryConnections = CAppEnvironment.getRegistryHandler()
					.getRegistryConnections();
			if (registryConnections.length == 0) {
				RegistryConnection registryConnection = new RegistryConnection();
				try {
					registryConnection.setURL(new URL(DEFAULT_REGISTRY_URL));
				} catch (MalformedURLException e) {
					log.error(ERROR_REGISTRY_URL, e);

					IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, REASON_REGISTRY_URL);
					ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_MSG_HEADER,
							ERROR_REGISTRY_URL, editorStatus);
				}
				registryConnection.setPath(C_REG_PATH_PREFIX);
			}
			selectedPathData = CAppEnvironment.getRegistryHandler()
					.selectRegistryPath(registryConnections, REGISTRY_BROWSER,
							SELECT_REGISTRY_RESOURCE, IRegistryHandler.SELECTED_REGISTRY_RESOURCE);
			//String mediaType = selectedPathData.getMediaType();
			String mediaType = "xml"; // TODO need to replace this with the above commented out line when the new kernle version is available
			fileType = extractFileTypeFromRegistryResource(fileType, mediaType);
			SchemaGeneratorFactory schemaGenFactory = new SchemaGeneratorFactory();
			schemaGenerator = schemaGenFactory.getSchemaGenerator(fileType);
			FILE_NAME = FILE_NAME_VALUE + "." + fileType.toString().toLowerCase();
			File outputDirectory = new File(TEMP_OUTPUT);
			if (!outputDirectory.exists()) {
				outputDirectory.mkdir();
			}
			outputFile = new File(TEMP_OUTPUT  + File.separator + FILE_NAME);
			if (outputFile.exists()) {
				outputFile.delete();
				outputFile.createNewFile();
			}
			CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem(
					(IRegistryData) selectedPathData, outputFile);
		}catch (Exception e) {
			// TODO Auto-generated catch block
		} finally {
			//do nothing
		}	
		if (schemaGenerator instanceof SchemaGeneratorForXSD) {
			try {
				schemaContent = schemaGenerator.getSchemaContent(TEMP_OUTPUT + File.separator + FILE_NAME);
			} catch (IOException e) {
				log.error("Error while generating avro schema", e);
			}
		} else {
			try {
				schemaContent = schemaGenerator.getSchemaResourcePath(TEMP_OUTPUT + File.separator + FILE_NAME);
			} catch (IOException e) {
				log.error("Error while generating avro schema", e);
			}
		}
		
		return schemaContent;
	}

	private static FileType extractFileTypeFromRegistryResource(
			FileType fileType, String mediaType) {
		if (mediaType.contains("xml")) {
			fileType = FileType.XML;
		} else if (mediaType.contains("xsd")) {
			fileType = FileType.XSD;
		} else if (mediaType.contains("json")) {
			fileType = FileType.JSON;
		} else {
			//need to handle for avro schema and json schema and also non recognised file type
		}
		return fileType;
	}

}
