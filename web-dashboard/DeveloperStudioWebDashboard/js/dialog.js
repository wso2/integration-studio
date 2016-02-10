
var projectFunction = "";

$(document).ready(function() {
   
    // IMPORTANT: You must call .steps() before calling .formValidation()
    $('#projectWizardForm')
        .steps({
            headerTag: 'h2',
            bodyTag: 'section',
            onStepChanged: function(e, currentIndex, priorIndex) {
                // You don't need to care about it
                // It is for the specific demo
               // adjustIframeHeight();
            },
            // Triggered when clicking the Previous/Next buttons
            onStepChanging: function(e, currentIndex, newIndex) {
                

                var isValidStep = true;//fv.isValidContainer($container);
                if (isValidStep === false || isValidStep === null) {
                    // Do not jump to the next step
                    return false;
                }

                return true;
            },
            // Triggered when clicking the Finish button
            onFinishing: function(e, currentIndex) {
               
                var isValidStep = true; //fv.isValidContainer($container);
                if (isValidStep === false || isValidStep === null) {
                    return false;
                }

                return true;
            },
            onFinished: function(e, currentIndex) {
                // Uncomment the following line to submit the form using the defaultSubmit() method
                // $('#profileForm').formValidation('defaultSubmit');
                var project = {};
                project.name = $('#projectName').val(); //"myproject3";
                project.location = $('#location').val() + project.name;
                var mavenInfo = {};
                mavenInfo.artifactId = $('#artifactID').val();
                mavenInfo.groupId = $('#groupID').val();
                mavenInfo.version = $('#version').val();
                project.mavenInfo = mavenInfo;
                var projectString = JSON.stringify(project);
                var result = ExecuteCustomFunction(projectFunction, projectString);
                $('#projectCreationWizardModal').modal('hide');
            }
        })

});

function createNewProject() {
	var workspace = ExecuteCustomFunction("getWorkspaceLocation");
	$('#projectName').val("");
	$('#location').val(workspace + "/");
	$('#artifactID').val("analytics.sample");
	$('#groupID').val("org.wso2.test");
	$('#version').val("1.0.0");
	projectFunction = "newAnalyticsProject";
	$('#projectCreationWizardModal').modal();
}

function createNewRegistryProject(){
	var workspace = ExecuteCustomFunction("getWorkspaceLocation");
	$('#projectName').val("");
	$('#location').val(workspace + "/");
	$('#artifactID').val("registry.sample");
	$('#groupID').val("org.wso2.test");
	$('#version').val("1.0.0");
	projectFunction = "newGeneralProject";
	$('#projectCreationWizardModal').modal();
}
