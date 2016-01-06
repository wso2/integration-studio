<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%--
  ~  Copyright (c) 2008, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  ~
  ~  Licensed under the Apache License, Version 2.0 (the "License");
  ~  you may not use this file except in compliance with the License.
  ~  You may obtain a copy of the License at
  ~
  ~        http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~  Unless required by applicable law or agreed to in writing, software
  ~  distributed under the License is distributed on an "AS IS" BASIS,
  ~  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~  See the License for the specific language governing permissions and
  ~  limitations under the License.
  --%>
<%@ page import="org.wso2.carbon.mediator.service.ui.Mediator" %>
<%@ page import="org.wso2.carbon.mediator.datamapper.DataMapperMediator" %>
<%@ page import="org.wso2.carbon.sequences.ui.util.SequenceEditorHelper" %>

<%! public boolean nullChecker(String strChecker) {

    if (strChecker == null) {
        return false;
    } else if (strChecker != null) {
        return true;
    } else if ((!(strChecker.equalsIgnoreCase("")))) {
        return true;
    }
    return false;
}%>

<%
    Mediator mediator = SequenceEditorHelper.getEditingMediator(request, session);
    if (!(mediator instanceof DataMapperMediator)) {
        // todo : proper error handling
        throw new RuntimeException("Unable to edit the mediator");
    }
    DataMapperMediator dataMapperMediator = (DataMapperMediator) mediator;
    String config = request.getParameter("config");
    if(nullChecker(config)) {
        dataMapperMediator.setConfigurationKey(config);
    }
    String inputSchema = request.getParameter("inputSchema");
    if(nullChecker(inputSchema)) {
        dataMapperMediator.setInputSchemaKey(inputSchema);
    }
    String outputSchema = request.getParameter("outputSchema");
    if(nullChecker(outputSchema)) {
        dataMapperMediator.setOutputSchemaKey(outputSchema);
    }

    dataMapperMediator.setInputType(Integer.parseInt(request.getParameter("mediator.datamapper.inputType")));
    dataMapperMediator.setOutputType(Integer.parseInt(request.getParameter("mediator.datamapper.outputType")));
    dataMapperMediator.getProperties().clear(); // to avoid duplicates

%>

