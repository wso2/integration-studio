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

var httpUrl = window.location.protocol + "//" + window.location.host;
if (BPSTenant != undefined && BPSTenant.length > 0) {
    //BPSTenant is defined in template/partials/header.jag to transfer tenant domain to browser side javascripts
    var appName = "t/" + BPSTenant + "/jaggeryapps/humantask-explorer"; //TODO finalize appName
} else {
    var appName = "humantask-explorer"; //TODO finalize appName
}


/**
 * function to make ajax call to claim task
 * @param id target task id
 */
function claimTask(id) {
    var requestUrl = "/" + appName + "/action?type=claim_task&tid=" + id;
    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            }
            else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }
            else {

                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Claim task");
                $('#additionalInfoErr').show();
            }
        },

        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }


    });
}

/**
 * function to make ajax call to start task
 * @param id target task id
 */
function startTask(id) {
    var requestUrl = "/" + appName + "/action?type=start_task&tid=" + id;
    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            }
            else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }
               else { //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Start task");
                $('#additionalInfoErr').show();
            }

        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to stop task
 * @param id task id
 */
function stopTask(id) {
    var requestUrl = "/" + appName + "/action?type=stop_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;

            }
            else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Stop task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to release task
 * @param id task id
 */
function releaseTask(id) {
    var requestUrl = "/" + appName + "/action?type=release_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/taskview?id=" + id;

            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                var session = session.get("authSuccess");
                if(!session){
                    window.location = httpUrl + "/" + appName +"/login";
                }
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Release task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to suspend task
 * @param id task id
 */
function suspendTask(id) {
    var requestUrl = "/" + appName + "/action?type=suspend_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                var session = session.get("authSuccess");
                if(!session){
                    window.location = httpUrl + "/" + appName +"/login";
                }
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Suspend task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}


/**
 * function to make ajax call to resume suspended task
 * @param id task id
 */
function resumeTask(id) {
    var requestUrl = "/" + appName + "/action?type=resume_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Resume task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}


/**
 * function to make ajax call to fail task
 * @param id task ID
 */
function failTask(id) {
    var requestUrl = "/" + appName + "/action?type=fail_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Fail task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to update comments
 * @param id task id
 */
function updateComments(id) {
    $('#commentTab').attr("class", "active");
    $('#historyTab').attr("class", "");
    $('#attachmentTab').attr("class", "");

    $('#commentList').css("display", "block");
    $('#historyList').css("display", "none");
    $('#AttchmentsList').css("display", "none");

    $('#addComment').css("display", "block");

    var requestUrl = "/" + appName + "/update?type=update_comments&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                var ns1NS = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803';
                var commentList = data.firstChild.getElementsByTagNameNS('http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803', 'comment');
                var commentViewList = '';

                for (var i = 0; i < commentList.length; i++) {
                    var dateInfo = new Date(commentList[i].getElementsByTagNameNS(ns1NS, 'lastModifiedTime')[0].textContent);

                    commentViewList = commentViewList + '<li class="list-group-item" id="comment_' + commentList[i].getElementsByTagNameNS(ns1NS, 'id')[0].textContent + '">\
                                                                <div>' + commentList[i].getElementsByTagNameNS(ns1NS, 'addedBy')[0].textContent + ' added a comment - \
                                                                    <time>' + dateInfo.toDateString() + ' ' + dateInfo.toLocaleTimeString() + '</time>\
                                                                    <a href="#additionalInfoSection" onclick="deleteComment(' + id + ',' + commentList[i].getElementsByTagNameNS(ns1NS, 'id')[0].textContent + ')">\
                                                                        <span class="glyphicon glyphicon-remove" style="float:right; font-size:85%; color:#B0B0B0"></span>\
                                                                    </a>\
                                                                </div>\
                                                                <div>' + commentList[i].getElementsByTagNameNS(ns1NS, 'text')[0].textContent + '</div>\
                                                            </li>';
                }

                $('#commentList').html(commentViewList);
            }else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }  else  {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Update Comments task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to add comment
 * @param id task id
 */
function addComment(id) {
    var text = document.getElementById("addCommentTextArea").value;
    var requestUrl = "/" + appName + "/action?type=addComment_task&tid=" + id;
    var requestPayload = "<addComment><text><![CDATA[" + text + "]]></text></addComment>";

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        data: requestPayload,
        contentType: "text/xml",
        dataType: "xml",
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                $('#addCommentModal').modal('hide');
                document.getElementById("addCommentTextArea").value='';
            }else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Add Comment task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });

    $('#addCommentModal').modal('hide');
    $('#addCommentModal').on('hidden.bs.modal', function (e) {
        //update comment list in ui
        updateComments(id);
    });

}

/**
 * function to make ajax call to update history
 * @param id
 */
function updateHistory(id) {
    $('#commentTab').attr("class", "");
    $('#historyTab').attr("class", "active");
    $('#attachmentTab').attr("class", "");

    $('#commentList').css("display", "none");
    $('#historyList').css("display", "block");
    $('#AttchmentsList').css("display", "none");

    $('#addComment').css("display", "none");

    var requestUrl = "/" + appName + "/update?type=update_history&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                var historyList = data.firstChild.getElementsByTagName('event');
                var historyViewList = '';

                for (var i = 0; i < historyList.length; i++) {
                    var dateInfo = new Date(historyList[i].getElementsByTagName('eventTime')[0].textContent);
                    historyViewList = historyViewList + '<li class="list-group-item">\
                                                            <div> <b>User : </b>'
                        + historyList[i].getElementsByTagName('eventInitiator')[0].textContent
                        + '</div>\
                                                            <div> <b>Operation : </b>'
                        + historyList[i].getElementsByTagName('eventType')[0].textContent
                        + '</div>\
                                                            <div> <b>Time : </b>'
                        + '<time>' + dateInfo.toDateString() + ' ' + dateInfo.toLocaleTimeString() + '</time>'
                        + '</div>\
                                                            <div> <b>Old State : </b>'
                        + historyList[i].getElementsByTagName('oldState')[0].textContent
                        + '</div>\
                                                            <div> <b>New State : </b>'
                        + historyList[i].getElementsByTagName('newState')[0].textContent
                        + '</div>\
                                                        </li>';
                }
                $('#historyList').html(historyViewList);
            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Update History task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to update attachments
 * @param id task id
 */
function updateAttachments(id) {
    $('#commentTab').attr("class", "");
    $('#historyTab').attr("class", "");
    $('#attachmentTab').attr("class", "active");

    $('#commentList').css("display", "none");
    $('#historyList').css("display", "none");
    $('#AttchmentsList').css("display", "block");

    $('#addComment').css("display", "none");

    var requestUrl = "/" + appName + "/update?type=update_attachments&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;

            if (success === 'true') {
                //successful
                var ns1NS = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803';
                var ns2NS = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803';
                var attachmentList = data.firstChild.getElementsByTagNameNS(ns2NS, 'info');
                var bpsUrl = data.firstChild.getElementsByTagName('bpsUrl')[0].textContent;

                var attachmentViewList = '';
                for (var i = 0; i < attachmentList.length; i++) {
                    var dateInfo = new Date(attachmentList[i].getElementsByTagNameNS(ns1NS, 'attachedTime')[0].textContent);

                    attachmentViewList = attachmentViewList + '<li class="list-group-item" id="attachment_' + attachmentList[i].getElementsByTagNameNS(ns1NS, 'identifier')[0].textContent + '">'
                        + '<div>'
                        + attachmentList[i].getElementsByTagNameNS(ns1NS, 'name')[0].textContent
                        + '<a href="' + attachmentList[i].getElementsByTagNameNS(ns1NS, 'identifier')[0].textContent + '"'
                        + 'class="btn btn-link btn-xs" role="button" style="float:right;">'
                        + 'Download'
                        + '</a>'
                        + '</div>'
                        + '<div style="color:#B0B0B0;">'
                        + 'added by ' + attachmentList[i].getElementsByTagNameNS(ns1NS, 'attachedBy')[0].textContent
                        + ' on <time>' + dateInfo.toDateString() + ' ' + dateInfo.toLocaleTimeString() + '</time>'
                        + '</div>'
                        + '</li>';
                }

                attachmentViewList = attachmentViewList + '<li class="list-group-item"><form id="attachment_upload_form" method="post" name="attachmentUpload" '
                + 'action="' + bpsUrl + '/fileupload/attachment-mgt" enctype="multipart/form-data" target="_self">'
                + '<input type="hidden" id="uRedirect" name="redirect" value="'+ httpUrl + "/" + appName +'/task?id='
                + id + '#additionalInfoSection">'
                + '<input type="hidden" id="taskID" name="taskID" value="' + id + '">'
                + '<div class="row">'
                + '<div class="col-lg-1">File</div>'
                + '<div class="col-lg-4"><input type="file" class="filestyle" data-classButton="btn btn-primary" id="fileToUploadID" name="fileToUpload" class="btn btn-info"></div>'
                + '<div><input name="attachmentUploadButton" class="btn btn-danger" style="float:right;" type="button"'
                + ' value="upload" onclick="uploadAttachment();"></div>'
                + '</div>'
                + '</form></li>';

                $('#AttchmentsList').html(attachmentViewList);
            }else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }  else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Update Attachements task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }

    });

}

/**
 * function to upload attachment
 * @returns {boolean}
 */
function uploadAttachment() {

    if( $('#fileToUploadID').val() =='' || $('#fileToUploadID').length ==0)
    {
        $('#InfoErrMsg').html("Please select file to upload attachment.");
        $('#additionalInfoErr').show();
        return true ;
    }
    document.attachmentUpload.submit();
    return true;
}


/**
 * function to make ajax call to delete comment
 * @param id task id
 * @param commentId comment id
 */
function deleteComment(id, commentId) {
    var requestUrl = "/" + appName + "/action?type=deleteComment&tid=" + id + "&commentId=" + commentId;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;

            if (success === 'true') {
                //successful
                var commentElementId = "comment_" + commentId;
                var element = document.getElementById(commentElementId);
                if (element != null) {
                    element.parentNode.removeChild(element);
                } else {
                    $('#InfoErrMsg').html("ERROR : element " + commentElementId + " not found. Please refresh the page");
                    $('#additionalInfoErr').show();
                }
            }
            else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Delete Comment task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}

/**
 * function to make ajax call to assign task to assignable user
 * @param id task id
 */
function assignTask(id) {
    var assignee = document.getElementById("assignableUserList").value;
    var requestUrl = "/" + appName + "/action?type=assign_task&tid=" + id + "&assignee=" + assignee;

    $.ajax({

        type: 'POST',
        url: httpUrl + requestUrl,
        dataType: "xml",
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;

            if (success === 'true') {
                //successful
                $('#assignTaskModal').modal('hide');
                //redirect to task view
                window.location = httpUrl + "/" + appName + "/taskview?id=" + id;

            }else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }  else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Assign task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#assignTaskModal').modal('hide');
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }

    });

}

/**
 * function to make ajax call to retrieve task assignable user list
 * @param id task id
 */
function assignTaskModalUpdate(id) {
    var requestUrl = "/" + appName + "/update?type=update_assignableUsers&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;

            if (success === 'true') {
                //successful
                var ns2NS = 'http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803';
                var userList = data.firstChild.getElementsByTagNameNS(ns2NS, 'user');

                var userListDisplay = '';
                if (userList.length > 0) {
                    for (var i = 0; i < userList.length; i++) {
                        userListDisplay = userListDisplay + '<option value="' + userList[i].textContent + '">' + userList[i].textContent + '</option>';
                    }

                    $('#assignableUserList').html(userListDisplay);
                    $('#taskAssignBtn').removeAttr('disabled');
                    $('#userUnavailableAlert').hide();

                } else if (success === 'timeout') {
                    window.location = httpUrl + "/" + appName + "/login";
                } else {
                    //no users available to assign
                    $('#assignableUserList').html(userListDisplay);
                    $('#taskAssignBtn').attr('disabled', 'disabled');
                    $('#userUnavailableAlert').show();
                }
                //show modal
                $('#assignTaskModal').modal();
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to AssignTask Modal Update Failed");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });

}

/**
 * function to submit form to specified action
 * @param formId
 * @param formAction
 */
function submitForm (formId, formAction) {

    var requestUrl = "/" + appName + formAction;

    document.forms.namedItem(formId).action = requestUrl;
    document.forms.namedItem(formId).submit();
}


function completeTask (formId, formAction) {
    submitForm (formId, formAction);
}

function showSetPriorityModal() {
    $('#setPriorityModal').modal();
}

function setPriority(id){
    var priority = document.getElementById("priorityList").value;
    var requestUrl = "/" + appName + "/action?type=set_priority&tid=" + id + "&priority=" + priority;

    $.ajax({

        type: 'POST',
        url: httpUrl + requestUrl,
        dataType: "xml",
        success: function (data) {
            var success = data.firstChild.getElementsByTagName('success')[0].textContent;

            if (success === 'true') {
                //successful
                $('#setPriorityModal').modal('hide');
                //redirect to task view
                window.location = httpUrl + "/" + appName + "/taskview?id=" + id;

            }else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            }  else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to set new priority");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#setPriorityModal').modal('hide');
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }

    });
}

/**
 * function to make ajax call to skip task
 * @param id task ID
 */
function skipTask(id) {
    var requestUrl = "/" + appName + "/action?type=skip_task&tid=" + id;

    $.ajax({
        type: 'POST',
        url: httpUrl + requestUrl,
        success: function (data) {

            var success = data.firstChild.getElementsByTagName('success')[0].textContent;
            if (success === 'true') {
                //successful
                window.location = httpUrl + "/" + appName + "/task?id=" + id;
            } else if (success === 'timeout') {
                window.location = httpUrl + "/" + appName + "/login";
            } else {
                //unsuccessful
                $('#InfoErrMsg').html("ERROR : Unable to Skip task");
                $('#additionalInfoErr').show();
            }
        },
        error: function (response) {
            $('#InfoErrMsg').html("CONNECTION ERROR : please refresh page");
            $('#additionalInfoErr').show();
        }
    });
}



/**
 Function to set date picker to date input elements
 */
function setDatePicker (dateElement) {
    var elementID = '#' + dateElement;
    $(elementID).daterangepicker({
                                     singleDatePicker: true,
                                     showDropdowns: true,
                                     locale: {
                                         format: 'MM/DD/YYYY'
                                     }
                                 });
}
