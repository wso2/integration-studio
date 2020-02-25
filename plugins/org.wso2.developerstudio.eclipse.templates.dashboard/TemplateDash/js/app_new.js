var colorOrange = "#f47a20";
var colorOrange2 = "#ffffff";
var colorBorder = "#ffffff";
var rectAnimationDuration = 50;
var centerLogo;
var portValue = resolveGetParam("port");

function resolveGetParam(param) {
    var paramValue = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === param) paramValue = decodeURIComponent(tmp[1]);
        });
    return paramValue;
}

var w = window,
    d = document,
    e = d.documentElement,
    g = d.getElementsByTagName('body')[0],
    x = w.innerWidth || e.clientWidth || g.clientWidth,
    totalHeight = w.innerHeight || e.clientHeight || g.clientHeight;

var animationDuration = 250;

function setViewPortFullScreen(duration) {
    svgArea.animate({viewBox: (cx - 650 / 2) + ' ' + (cy - 650 / 2) + ' ' + 650 + ' ' + 650}, duration);
}

//This value is injected to this script at browser widget initialization
//var portValue = serverDetails.port; 

var welcomeNodeArray;
GetDashboardWizards();
loadDisableWelcomePageParameter();
function loadWelcomeNodes(contributionsString) {
    var contributions = JSON.parse(contributionsString);
    var welcomeNodes = [];
    contributions.forEach(function (contribution) {
        var welcomeNode = {};
        welcomeNode.title = contribution.name;
        //welcomeNode.title = welcomeNode.title.split(/ /g)[0];
        welcomeNode.icon = contribution.iconURL;
        welcomeNode.nodes = [];
        contribution.wizards.forEach(function (wizard) {
            var wizardNode = {};
            wizardNode.title = wizard.id;
            wizardNode.wizardID = wizard.name;
            wizardNode.priority = wizard.priority;
            wizardNode.description = wizard.description;
            wizardNode.label = wizard.title;
            wizardNode.image = wizard.image;
            welcomeNode.nodes.push(wizardNode);
        });
        welcomeNodes.push(welcomeNode);
    });
    welcomeNodeArray = welcomeNodes;
    drawWelcomeNodes();
}


var esbNewProjectWizard = "org.wso2.developerstudio.eclipse.artifact.newesbsolutionproject";
var projectExportWizard = "org.wso2.developerstudio.eclipse.distribution.importAsArtifact";

var dataSourceProject = "org.wso2.developerstudio.eclipse.artifact.newdatasourceproject";
var dataServiceProject = "org.wso2.developerstudio.eclipse.artifact.newdsproject";

$("#DataServiceProject").click(function(){
	//OpenIDEWizard(esbNewProjectWizard);
	openWizard(dataServiceProject);
}); 

$("#DataSourceProject").click(function(){
	openWizard(dataSourceProject);
});

var BPMNProject = "org.wso2.developerstudio.bpmn.wizards.CreateBPMNProjectWizard";
var BPELProject = "org.wso2.developerstudio.eclipse.artifact.newbpelartifact";
var HumanTaskProject = "org.wso2.developerstudio.humantaskeditor.wizards.HumanTaskProjectWizard";

$("#BPMNProject").click(function(){
	//OpenIDEWizard(esbNewProjectWizard);
	openWizard(BPMNProject);
}); 

$("#HumanTaskProject").click(function(){
	openWizard(HumanTaskProject);
});

$("#BPELWorkFlowProject").click(function(){
	openWizard(BPELProject);
});

var mavenWizard = "org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard";
var cappWizard = 'org.wso2.developerstudio.eclipse.distribution.project';
var serverWizard = 'org.eclipse.wst.server.ui.new.server';
var registryWizard = 'org.wso2.developerstudio.eclipse.general.project';
var configWizard = 'org.wso2.developerstudio.eclipse.artifact.newesbproject';
var mediatorWizard = 'org.wso2.developerstudio.eclipse.artifact.newmediatorartifact';
var dockerWizard = 'org.wso2.developerstudio.eclipse.artifact.newdockerproject';
var kubernetesWizard = 'org.wso2.developerstudio.eclipse.artifact.newkubernetesproject';

$("#CompositeApplicationProject").click(function(){
	openWizard(cappWizard);
});

$("#RegistryProject").click(function(){
	openWizard(registryWizard);
});

$("#MavenMultiModuleProject").click(function(){
	openWizard(mavenWizard);
});

$("#Server").click(function(){
	openWizard(serverWizard);
});

$("#ConfigProject").click(function(){
	openWizard(configWizard);
});

$("#MediatorProject").click(function(){
	openWizard(mediatorWizard);
});

$("#DockerProject").click(function(){
	openWizard(dockerWizard);
});

$("#KubernetesProject").click(function(){
	openWizard(kubernetesWizard);
});

/*if((GetWizardDescription(mavenWizard) != null)){
    welcomeNodeArray.push({title: "Maven", nodes: [
        {title: '', wizardID: mavenWizard}
    ]});
}

if((GetWizardDescription(cappWizard) != null)){
    welcomeNodeArray.push({title: "CApp", nodes: [
        {title: '', wizardID: cappWizard}
    ]});
}

if((GetWizardDescription(serverWizard) != null)){
    welcomeNodeArray.push({title: "Add runtime", nodes: [
        {title: '', wizardID: serverWizard}
    ]});
}*/

$("#createNewProject").click(function(){
	//OpenIDEWizard(esbNewProjectWizard);
	openWizard(esbNewProjectWizard);
}); 

$("#openExistingProject").click(function(){
	openWizard(projectExportWizard);
});

$('#show-welcome').change(function() {
	updateWelcomeDisplayConfiguration();
});

function openWizard(wizardid) {
    $.post("http://127.0.0.1:"+portValue+"/servlet/openide", { status: wizardid } ,function(data, status){
    });
}

function GetDashboardWizards() {
	var jsonString;
    $.get("http://127.0.0.1:"+portValue+"/servlet/getwizards", function(data, status){
        loadWelcomeNodes(JSON.stringify(data));
    });
}

/*function GetWizardDetails(wizardid) {
    $.post("http://localhost:8680/getwizarddetails", { status: wizardid } ,function(data, status){
        return data;
    });
}*/

function drawWelcomeNodes(){
	welcomeNodeArray.forEach(function (welcomeNode) {
	//	 $("#root-container").append("<h1>" + welcomeNode.title + "</h1>" );
		
		 welcomeNode.nodes.forEach(function (childNode) {
			escapedChildTitle = childNode.title.replace(/\./g, '');
			templateNode = createTemplateNode(escapedChildTitle, childNode.label, childNode.description, childNode.image);	
			if ( welcomeNode.title == "ESB_Templates"){
				$("#esb-templates").append(templateNode);
			} else if (welcomeNode.title == "DSS_Templates"){
				$("#dss-templates").append(templateNode);
			}					
			$("#"+escapedChildTitle).click(function(){
				openWizard(childNode.wizardID);
		    });
		});
		 
		 
		
	});
}

function createTemplateNode(templateID, templateName, templateDescription, image){
	if(image != null || image != "") {
		resolvedimage = "src='./images/template_thumb.jpg'";
	} else {
		resolvedimage = "src='data:image/png;base64, " + image + "'";
	}
	var html = "<div class='col-xs-6 col-sm-6 col-md-2 col-lg-2 template' data-title='" + templateName + "' id='" + templateID + "'> <div class='thumb'> <a href='#'>" +
			" <img " + resolvedimage + " class='img-responsive'> <div class='hover-opaque scrollbar-macosx'>" + templateDescription + 
			"</div></a> </div><div class='thumb thumb-caption text-center'> <figcaption><a href='#' " +
			"data-toggle='tooltip' data-placement='right' title='" + templateName + "'>" + templateName + 
			"</a></figcaption> </div></div>";
	return html;
}

function setOpacityOfLogo(op, dur) {
    centerLogo.select('#circle3041').animate({opacity: op}, dur);
    centerLogo.select('#path3043').animate({opacity: op}, dur);
    centerLogo.select('#path3045').animate({opacity: op}, dur);
}

function hideUnselectedNodes() {
    if (selectedNode != null) {
        centerCircle.animate({opacity: 0}, animationDuration);
        setOpacityOfLogo(0, animationDuration);
        centeredMainText.animate({opacity: 0}, animationDuration);
        welcomeNodeArray.forEach(function (node) {
            node.line.animate({opacity: 0}, animationDuration / 5);
            if (node != selectedNode) {
                node.circle.animate({opacity: 0}, animationDuration);
                node.text.animate({opacity: 0}, animationDuration);
                node.image.animate({opacity: 0}, animationDuration);
            }
        });
    }
}

function showUnselectedNodes() {
    centerCircle.animate({opacity: 100}, animationDuration);
    setOpacityOfLogo(100, animationDuration);
    centeredMainText.animate({opacity: 100}, animationDuration);
    welcomeNodeArray.forEach(function (node) {
        node.line.animate({opacity: 100}, animationDuration);
        if (node != selectedNode) {
            node.circle.animate({opacity: 100}, animationDuration);
            node.text.animate({opacity: 100}, animationDuration);
            node.image.animate({opacity: 100}, animationDuration);
        }
    });
}

function searchTemplates(searchInput, templateList){
	$(searchInput).keyup(function(){
        var valThis = $(this).val().toLowerCase();
        if(valThis == ""){
            $(templateList +' > .template').show();
        } else {
            $(templateList + ' > .template').each(function(){
                var text = $(this).attr("data-title").toLowerCase();
                (text.indexOf(valThis) >= 0) ? $(this).show() : $(this).hide();
            });
        };
    });
}

function updateWelcomeDisplayConfiguration() {
	var checkBox = document.getElementById("show-welcome");
	$.post("http://127.0.0.1:" + portValue + "/servlet/savewelcomeconfig", { status: checkBox.checked } ,function(data, status){
    });
}

function loadDisableWelcomePageParameter() {
	 $.get("http://127.0.0.1:" + portValue + "/servlet/getwelcomeconfig", function(data, status) {
		 var checkBox = document.getElementById("show-welcome");   
		 var data = JSON.stringify(data);
		 var disableWelcome = JSON.parse(data);
		 if (disableWelcome.state == true) {
			 checkBox.checked = false;
		 } else {
			 checkBox.checked = true;
		 }
	 });
	
}

$('#zoomInIconP').click(function () {
    setSelectedNode(null);
    setTimeout(function () {
        setViewPortFullScreen(400);
        showUnselectedNodes();
    }, animationDuration);
});

$(document).ready(function(){
    $('.scrollbar-macosx').scrollbar();
    
    searchTemplates("#search", ".template-list");
    searchTemplates("#dss-search", ".dss-template-list");
});
