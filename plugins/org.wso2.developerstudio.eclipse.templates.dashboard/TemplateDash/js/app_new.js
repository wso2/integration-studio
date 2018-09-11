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
var projectExportWizard = "org.wso2.developerstudio.eclipse.distribution.exportAsArtifact";

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

/*var mavenWizard = "org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard";
var cappWizard = 'org.wso2.developerstudio.eclipse.distribution.project';
var serverWizard = 'org.eclipse.wst.server.ui.new.server';

if((GetWizardDescription(mavenWizard) != null)){
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

function openWizard(wizardid) {
    $.post("http://localhost:"+portValue+"/servlet/openide", { status: wizardid } ,function(data, status){
    });
}

function GetDashboardWizards() {
	var jsonString;
    $.get("http://localhost:"+portValue+"/servlet/getwizards", function(data, status){
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
	if(image == null || image == "") {
		resolvedimage = "data-src='holder.js/533x400?auto=yes&random=yes'";
	} else {
		resolvedimage = "src='data:image/png;base64, " + image + "'";
	}
	var html = "<div class='col-sm-4 col-md-3 template' id='" + templateID + "'> <div class='thumb'> <a href='#'>" +
			" <img " + resolvedimage + " class='img-responsive'> <div class='hover-opaque'>" + templateDescription + 
			"</div></a> </div><div class='thumb thumb-caption text-center'> <figcaption><a href='#'>" + templateName + 
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

$('#zoomInIconP').click(function () {
    setSelectedNode(null);
    setTimeout(function () {
        setViewPortFullScreen(400);
        showUnselectedNodes();
    }, animationDuration);
});

