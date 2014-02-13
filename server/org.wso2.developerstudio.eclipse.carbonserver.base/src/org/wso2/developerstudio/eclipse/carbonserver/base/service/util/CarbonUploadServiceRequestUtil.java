/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver.base.service.util;

import java.io.IOException;
import java.util.HashMap;

import javax.activation.DataHandler;
//import javax.xml.soap.SOAPConnection;
//import javax.xml.soap.SOAPFactory;

import org.apache.commons.httpclient.HttpException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.command.WTPInternalBrowserCommand;
import org.wso2.developerstudio.eclipse.carbonserver.base.exception.UserOperationCancelledException;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.ICarbonOperationManager;
import org.wso2.developerstudio.eclipse.server.base.core.IServerManager;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;

public final class CarbonUploadServiceRequestUtil {
	
	private static CarbonUploadServiceRequestUtil instance;
	
	private DataHandler dh;
//	private SOAPConnection connection;
//	private SOAPFactory soapFactory;
	private boolean isXml;
	private boolean isArchive;
	private boolean isService;
	private boolean isModule;
	private boolean isWSDL;
	private boolean alredyInit;
	private String anyFileUploaderUrl="http://localhost:9763/fileupload/*";
	//Private constructor
	private CarbonUploadServiceRequestUtil(){
	}
	
	public static CarbonUploadServiceRequestUtil getInstance(){
		if (instance == null) {
			instance = new CarbonUploadServiceRequestUtil();
		}
		return instance;
	}
	
//	private void init(){
//		try {
//			connection = SOAPConnectionFactory.newInstance().createConnection();
//			soapFactory = SOAPFactory.newInstance();
//			alredyInit = true;
//		} catch (UnsupportedOperationException e) {
//			log.error(e);
//		} catch (SOAPException e) {
//			log.error(e);
//		}
//	}
	
//	public String getWSDLConversionResultUrl(String resourceFile) throws HttpException, IOException{
//		String result=null;
//		if (resourceFile.toLowerCase().startsWith("http")){
//			result=convertWSDLUrl(resourceFile);
//		}else{
//			result=convertWSDLFile(new File(resourceFile));
//		}
//		return result;
//	}
//	
//	private String convertWSDLFile(File resourceFile) throws HttpException, IOException{
//		String UUid=uploadFile(resourceFile,null,anyFileUploaderUrl);
//		WSDLConverterServiceStub converterServiceStub = new WSDLConverterServiceStub();
//		ConvertWSDLUsingFile convertWSDLUsingFile=new ConvertWSDLUsingFile();
//		convertWSDLUsingFile.setUuid(UUid);
//		ConvertWSDLUsingFileResponse convertWSDLUsingFile2 = converterServiceStub.convertWSDLUsingFile(convertWSDLUsingFile);
//		return convertWSDLUsingFile2.get_return().substring(5);
//	}
//	
//	private String convertWSDLUrl(String resourceFile) throws HttpException, IOException{
//		WSDLConverterServiceStub converterServiceStub = new WSDLConverterServiceStub();
//		ConvertWSDLUsingURL convertWSDLUsingURL=new ConvertWSDLUsingURL();
//		convertWSDLUsingURL.setUrl(resourceFile);
//		ConvertWSDLUsingURLResponse convertWSDLUsingURL2 = converterServiceStub.convertWSDLUsingURL(convertWSDLUsingURL);
//		System.out.println(convertWSDLUsingURL2.get_return());
//		return convertWSDLUsingURL2.get_return().substring(5);
//	}
//	
//	public static String uploadFile(File resourceUrl,String validatorUrl,String url) throws HttpException, IOException{
//		File f = resourceUrl;
//		PostMethod filePost = new PostMethod(url);
//		Part part; 
//		if (validatorUrl==null)
//			part= new FilePart(f.getName(),f);
//		else
//			part= new FilePart(validatorUrl,f.getName(),f);
//		filePost.setRequestEntity(new MultipartRequestEntity(new Part[]{part}, filePost.getParams()));
//		HttpClient client = new HttpClient();
//		//filePost.setFollowRedirects(true);
//		int status = client.executeMethod(filePost);
//		String resultUUid=null;
//        resultUUid = filePost.getResponseBodyAsString();
//        filePost.releaseConnection();
//		return resultUUid;
//	}
	
	public String requestValidate(String resourceFile, String serverId,Shell shell) throws HttpException, IOException, Exception{
		String returnUUID = null;
		IServer server = CarbonServerManager.getServer(serverId);
		if (server.getServerState()!=IServer.STATE_STARTED){
			boolean serverResult = ServerController.getInstance().getServerManager().startServer(serverId,shell);
			if (!serverResult) throw new UserOperationCancelledException();;
		}
//		IServer runningServer = WSASServerManager.getRunningServer();
//		if (runningServer==null)
//			throw new WSASServerNotRunningException();
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String,Object> operationParameters=new HashMap<String,Object>();
		int action=0;
		if (isService) {
			if (isXml) {
				action=ICarbonOperationManager.OPERATION_SERVICE_XML_VALIDATE;

			}else{
				action=ICarbonOperationManager.OPERATION_SERVICE_ARCHIVE_VALIDATE;
			}
		}else if (isModule){
			if (isXml) {
				action=ICarbonOperationManager.OPERATION_MODULE_XML_VALIDATE;
			}else{
				action=ICarbonOperationManager.OPERATION_MODULE_ARCHIVE_VALIDATE;
			}
		}else if (isWSDL){
			if (resourceFile.toLowerCase().startsWith("http"))
				action=ICarbonOperationManager.OPERATION_WSDL_CONVERT_URL;
			else
				action=ICarbonOperationManager.OPERATION_WSDL_CONVERT_FILE;
		}
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE, action);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PATH, resourceFile);
		returnUUID = wsasServerManager.executeOperationOnServer(server, operationParameters).toString();//getWSDLConversionResultUrl(resourceFile);
		return returnUUID;
	}
	
	public String sendRequestToServer(int action,String serverId,HashMap<String,Object> operationParameters,Shell shell) throws Exception {
		String returnUUID = null;
		IServer server = CarbonServerManager.getServer(serverId);
		prepareServer(serverId, shell);
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		returnUUID = wsasServerManager.executeOperationOnServer(server, operationParameters).toString();//getWSDLConversionResultUrl(resourceFile);
		return returnUUID;
	}
	
	public void prepareServer(String  serverId, Shell shell) throws UserOperationCancelledException{
		IServer server = CarbonServerManager.getServer(serverId);
		if (server.getServerState()!=IServer.STATE_STARTED){
			boolean serverResult = ServerController.getInstance().getServerManager().startServer(serverId,shell);
			if (!serverResult) throw new UserOperationCancelledException();;
		}
		
	}
	
	public void popupInternalBrowser(String url){
		WTPInternalBrowserCommand
			.popUpInrernalBrouwser(url);
	}

	public void popupExternalBrowser(String url){
		WTPInternalBrowserCommand
			.popUpExternalBrouwser(url);
	}
	
//	private String sendUploadFileToWSAS(File resourceFile, String fileType, 
//			String validateServiceEndpoint, String endOperation){		
//			try{
//				SOAPMessage message = MessageFactory.newInstance().createMessage();
//
//				QName uploadQName = new QName("http://org.apache.axis2/xsd","upload","ns");
//				SOAPElement uploadElement = soapFactory.createElement(uploadQName);
//
//				//set the attachement
//				dh = new DataHandler(new FileDataSource(resourceFile));
//				AttachmentPart attachment = message.createAttachmentPart(dh);
//				attachment.setContentId("myAttachment");
//				attachment.setContentType("txt/xml");
//
//				QName payloadQName = new QName("payload");
//				SOAPElement payloadElement = soapFactory.createElement(payloadQName);
//
//				QName attach = new QName("attachment");
//				SOAPElement attachmentElement = soapFactory.createElement(attach);
//				attachmentElement.setAttribute("href", "cid:" + attachment.getContentId());
//
//				//Add type element
//				QName attachmentId = new QName("type");
//				SOAPElement attachmentIdEle = soapFactory.createElement(attachmentId);
//				attachmentIdEle.addTextNode(fileType);
//
//				payloadElement.addChildElement(attachmentElement);
//				payloadElement.addChildElement(attachmentIdEle);
//
//				uploadElement.addChildElement(payloadElement);
//
//				message.getSOAPBody().addChildElement(uploadElement);
//				message.addAttachmentPart(attachment);
//
//				SOAPMessage result = connection.call(message,
//						validateServiceEndpoint);
//
//				SOAPPart part = result.getSOAPPart();
//				SOAPEnvelope envelope = part.getEnvelope();
//				SOAPBody body = envelope.getBody();
//
//				Node uploadResponse = body.getFirstChild();
//				Node returnNode = uploadResponse.getFirstChild();
//				String uuid = returnNode.getFirstChild().toString();
//
//				if(!body.hasFault())  {
//					Iterator iterator = result.getAttachments();
//					if(iterator.hasNext()) {
//						dh = ((AttachmentPart)iterator.next()).getDataHandler();
//						String fname = dh.getName();
//						//if (null != fname) return new File(fname);
//					}
//				}
//				if (isArchive) {
//					
//				}
//				String returnId = sendUUID(uuid,validateServiceEndpoint,endOperation);
//				return returnId;
//			} catch (UnsupportedOperationException e) {
//				log.error(e);
//			} catch (Exception e) {
//				log.error(e);
//			}
//		return null;
//	}
//	
	
	
//	   private String sendUUID(String uuid, String endPoint, String endOperation){
//			try {
//
//				SOAPMessage message = MessageFactory.newInstance().createMessage();
//				
//				QName uploadQName = new QName("http://org.wso2.wsf/tools",endOperation,"ns");
//				SOAPElement uploadElement = soapFactory.createElement(uploadQName);
//		
//				//Add type element
//				QName qnameEle = new QName("fileId");
//				SOAPElement attachmentIdEle = soapFactory.createElement(qnameEle);
//				attachmentIdEle.addTextNode(uuid);
//				uploadElement.addChildElement(attachmentIdEle);
//				
//				message.getSOAPBody().addChildElement(uploadElement);
//				
//				SOAPMessage result = connection.call(message,endPoint);
//				
//				SOAPPart part = result.getSOAPPart();
//				SOAPEnvelope envelope = part.getEnvelope();
//				SOAPBody body = envelope.getBody();
//				
//
//				if(!body.hasFault())  {
//					Iterator iterator = result.getAttachments();
//					if(iterator.hasNext()) {
//						dh = ((AttachmentPart)iterator.next()).getDataHandler();
//						String fname = dh.getName();
//					}
//				}
//				
//	   			Node uploadResponse = body.getFirstChild();
//				Node returnNode = uploadResponse.getFirstChild();
//				String uuid1 = returnNode.getFirstChild().toString();
//
//				return uuid1;
//				
//			} catch (UnsupportedOperationException e) {
//				log.error(e);
//			} catch (DOMException e) {
//				log.error(e);
//			} catch (SOAPException e) {
//				log.error(e);
//			}
//	    	return null;
//	    }

	public void setXml(boolean isXml) {
		this.isXml = isXml;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	public void setService(boolean isService) {
		this.isService = isService;
	}

	public void setModule(boolean isModule) {
		this.isModule = isModule;
	}
	
	public void reset() {
		this.isModule = false;
		this.isService = false;
		this.isXml = false;
		this.isArchive = false;
		this.isWSDL = false ;
	}

	public void setWSDL(boolean isWSDL) {
		this.isWSDL = isWSDL;
	}

}
