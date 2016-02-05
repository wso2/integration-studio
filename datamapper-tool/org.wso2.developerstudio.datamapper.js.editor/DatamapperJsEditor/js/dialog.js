
$(document).ready(function() {
   
    // IMPORTANT: You must call .steps() before calling .formValidation()
    $('#profileForm')
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
                project.location = "/home/susinda/runtime-EclipseApplication/" + project.name;
                var mavenInfo = {};
                mavenInfo.artifactId = "test.project";
                mavenInfo.groupId = "org.wso2";
                mavenInfo.version = "1.0.1";
                project.mavenInfo = mavenInfo;
                var projectString = JSON.stringify(project);
                var result = ExecuteCustomFunction("newAnalyticsProject", projectString);
                $('#welcomeModal').modal('hide');
            }
        })

});

function createNewProject() {
	  $('#welcomeModal').modal();
}
