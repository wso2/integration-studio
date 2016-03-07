/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Initialize HT server information
 * @param url back end url
 * @param sessionCookie session cookie
 */
function initHTServerInfo(url, sessionCookie) {
    this.URL = url;
    this.endPoint = this.URL + '/services/HumanTaskClientAPIAdmin/';
    this.renderingAPIEndpoint = this.URL + '/services/HumanTaskRenderingAPI/';
    this.cookie = sessionCookie;
}

/*
 * Function to send http request to back-end server
 * 
 * @returns response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function requestBPS(endPoint, soapAction, BPSSessionCookie, payload) {
    var BPSResponse;
    var httpClient = new XMLHttpRequest();
    httpClient.open('POST', endPoint, false);
    httpClient.setRequestHeader('COOKIE', BPSSessionCookie);
    httpClient.setRequestHeader('SOAPAction', soapAction);
    httpClient.setRequestHeader('Content-Type', 'text/xml');

    httpClient.send(payload);
    //BPSResponse = httpClient.responseText;
    BPSResponse = httpClient.responseText;
    if (httpClient.status == 401) { //session timed out

        return null;
    }
    else {
        return BPSResponse;
    }
}


/*
 * Function to make WS-HT simplequery request with basic limited parameters 
 * 
 * @returns response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function simpleQueryBasic(status, pageSize, pageNumber, queryCategory, queryOrder, queryOrderBy) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                                    xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:simpleQuery>\
                             <ns:simpleQueryInput>\
                                <ns1:status>' + status + '</ns1:status>\
                                <ns1:pageSize>' + pageSize + '</ns1:pageSize>\
                                <ns1:pageNumber>' + pageNumber + '</ns1:pageNumber>\
                                <ns1:simpleQueryCategory>' + queryCategory + '</ns1:simpleQueryCategory>\
                                <ns1:queryOrder>' + queryOrder + '</ns1:queryOrder>\
                                <ns1:queryOrderBy>' + queryOrderBy + '</ns1:queryOrderBy>\
                             </ns:simpleQueryInput>\
                          </ns:simpleQuery>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';

    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/simpleQuery';
    var BPSResponse;
    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    }
    else {
        return BPSResponse;
    }
}

/**
 * Function to make WS-HT simplequery request Advance parameters
 *
 * @returns  response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function simpleQueryAdvance(status, pageSize, pageNumber, queryCategory, queryOrder, queryOrderBy, taskName) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                            xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                            xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                        <soapenv:Body>\
                            <ns:simpleQuery>\
                                <ns:simpleQueryInput>\
                                    <ns1:status>' + status + '</ns1:status>\
                                    <ns1:undatedDate></ns1:undatedDate>\
                                    <ns1:taskName>' + taskName + '</ns1:taskName>\
                                    <ns1:pageSize>' + pageSize + '</ns1:pageSize>\
                                    <ns1:pageNumber>' + pageNumber + '</ns1:pageNumber>\
                                    <ns1:simpleQueryCategory>' + queryCategory + '</ns1:simpleQueryCategory>\
                                    <ns1:queryOrder>' + queryOrder + '</ns1:queryOrder>\
                                    <ns1:queryOrderBy>' + queryOrderBy + '</ns1:queryOrderBy>\
                                </ns:simpleQueryInput>\
                            </ns:simpleQuery>\
                        </soapenv:Body>\
                    </soapenv:Envelope>';

    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/simpleQuery';
    //var endPoint = this.URL + '/services/HumanTaskClientAPIAdmin/';

    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    }

    return BPSResponse;
}


/**
 * Function to make WS-HT loadTask request
 *
 * return response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function loadTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:loadTask>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:loadTask>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/loadTask';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        session.put('authSuccess', false);
        response.sendRedirect('login');
    }
    else {
        return BPSResponse;
    }
}

function loadAuthorisationParams(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:loadAuthorisationParams>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:loadAuthorisationParams>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/loadAuthorisationParams';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);

    return BPSResponse;
}

/**
 * Function to get input received by WS-HT service
 * @param id task identifier
 * @returns response payload
 */
function getInput(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" \
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                        <soapenv:Header/>\
                        <soapenv:Body>\
                            <ns:getInput>\
                                <ns:identifier>' + id + '</ns:identifier>\
                            </ns:getInput>\
                        </soapenv:Body>\
                    </soapenv:Envelope>';

    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/getInput';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    }
    return BPSResponse;
}

/**
 * Function to make WS-HT getComments request
 *
 * return response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function getComments(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                                <soapenv:Body>\
                                <ns:getComments>\
                                 <ns:identifier>' + id + '</ns:identifier>\
                                </ns:getComments>\
                                </soapenv:Body>\
                            </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/getComments';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    }
    return BPSResponse;
}


/**
 * function to claim task
 * @param id : ID of the task to claim
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */

function claimTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:claim>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:claim>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/claim';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make start tasks service request
 * @param id ID of the task to start progress
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function startTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                        xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:start>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:start>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/start';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}


/**
 * Function to make stop tasks service request
 * @param id ID of the task to stop progress
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function stopTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:stop>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:stop>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/stop';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}


/**
 * Function to make release tasks service request
 * @param id ID of the task to release
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function releaseTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:release>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:release>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/release';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make suspend tasks service request
 * @param id ID of the task to suspend
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function suspendTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                        xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:suspend>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:suspend>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/suspend';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}


/**
 * Function to make resume suspended tasks service request
 * @param id ID of the task to resume
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function resumeTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:resume>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:resume>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/resume';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make fail tasks service request
 * @param id ID of the task to fail
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function failTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                             xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                                             xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:fail>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:fail>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/fail';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make add comment service request
 * @param id ID of the task to add comment
 * @param text text comment
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function addComment(id, text) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:addComment>\
                             <ns:identifier>' + id + '</ns:identifier>\
                             <ns:text>' + text + '</ns:text>\
                          </ns:addComment>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/addComment';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make delete comment service request
 * @param id ID of the task to delete comment
 * @param taskId - ID of task of relates to comment
 * @param commentId - comment id
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function deleteComment(taskId, commentId) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                        xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:deleteComment>\
                             <ns:taskIdentifier>' + taskId + '</ns:taskIdentifier>\
                             <ns:commentIdentifier>' + commentId + '</ns:commentIdentifier>\
                          </ns:deleteComment>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/deleteComment';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to make assign task (delegate) service request
 * @param id - ID of the task to assign
 * @param userName - user name of the new asignee
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function assignTask(id, userName) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                            xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                            xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:delegate>\
                             <ns:identifier>' + id + '</ns:identifier>\
                             <ns:organizationalEntity>\
                                <ns1:user>' + userName + '</ns1:user>\
                             </ns:organizationalEntity>\
                          </ns:delegate>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/delegate';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to set a new priority for the task identified by given id
 * @param id - ID of the task to assign
 * @param priority - new priority value to be assigned to the task
 * @returns response payload from HumanTaskClientAPIAdmin service
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function setPriority(id, priority) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" \
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803">\
                            <soapenv:Header/>\
                                     <soapenv:Body>\
                                         <ns:setPriority>\
                                             <ns:identifier>' + id + '</ns:identifier>\
                                             <ns:priority>' + priority + '</ns:priority>\
                                         </ns:setPriority>\
                                     </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/setPriority'
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**
 * Function to skip a task identified by the given id
 * @param id - ID of the task to skip
 * @returns response payload from HumanTaskClientAPIAdmin service
 */
function skipTask(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                             xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                                             xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:skip>\
                             <ns:identifier>' + id + '</ns:identifier>\
                          </ns:skip>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/skip';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/**********************************************************************************************************************
 START web service requests to HumanTaskRenderingAPI admin service
 **********************************************************************************************************************/

/**
 * Function to retrieve HT renderings
 *
 * return response payload
 * @throws {exception java.net.ConnectException} if connection error occurred
 */
function getHTRenderings(id) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                            xmlns:hum="http://wso2.org/ht/schema/renderings/">\
                            <soapenv:Header/>\
                                     <soapenv:Body>\
                                         <hum:getRenderings>\
                                             <taskIdentifier>' + id + '</taskIdentifier>\
                                         </hum:getRenderings>\
                                     </soapenv:Body>\
                    </soapenv:Envelope>';
    var soapAction = 'http://wso2.org/ht/schema/renderings/getRenderings';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.renderingAPIEndpoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}


function setTaskOutput(id, valuesXmlListMessagePart) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" \
                                            xmlns:htr="http://wso2.org/ht/schema/renderings/">\
                                <soapenv:Header/>\
                                <soapenv:Body>\
                                    <htr:setTaskOutput>\
                                        <taskIdentifier>' + id + '</taskIdentifier>\
                                        <values>' + valuesXmlListMessagePart + '</values>\
                                    </htr:setTaskOutput>\
                                </soapenv:Body>\
                            </soapenv:Envelope>';

    var soapAction = 'http://wso2.org/ht/schema/renderings/setTaskOutput';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.renderingAPIEndpoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

function completeTask(id, valuesXmlListMessagePart) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" \
                                    xmlns:htr="http://wso2.org/ht/schema/renderings/">\
                            <soapenv:Header/>\
                                     <soapenv:Body>\
                                         <htr:completeTask>\
                                             <taskIdentifier>' + id + '</taskIdentifier>\
                                             <values>' + valuesXmlListMessagePart + '</values>\
                                         </htr:completeTask>\
                                     </soapenv:Body>\
                    </soapenv:Envelope>';

    var soapAction = 'http://wso2.org/ht/schema/renderings/completeTask';
    var BPSResponse = null;

    BPSResponse = requestBPS(this.renderingAPIEndpoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    } else {
        return BPSResponse;
    }
}

/* 
Retrieves the status of tasks for the dashboard
*/
function taskStatusQuery(status,pageSize,pageNumber) {
    var payload = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"\
                                    xmlns:ns="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803"\
                                    xmlns:ns1="http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803">\
                       <soapenv:Header/>\
                       <soapenv:Body>\
                          <ns:simpleQuery>\
                             <ns:simpleQueryInput>\
                                <ns1:status>' + status + '</ns1:status>\
                                <ns1:pageSize>' + pageSize + '</ns1:pageSize>\
                                <ns1:pageNumber>' + pageNumber + '</ns1:pageNumber>\
                          </ns:simpleQueryInput>\
                          </ns:simpleQuery>\
                       </soapenv:Body>\
                    </soapenv:Envelope>';

    var soapAction = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803/simpleQuery';
    var BPSResponse;
    BPSResponse = requestBPS(this.endPoint, soapAction, this.cookie, payload);
    if (BPSResponse == null) {
        return null;
    }
    else {
        return BPSResponse;
    }
}
