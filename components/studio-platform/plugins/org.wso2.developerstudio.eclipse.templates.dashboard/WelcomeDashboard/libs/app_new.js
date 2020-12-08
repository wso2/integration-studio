var colorOrange = "#f47a20";
var colorOrange2 = "#ffffff";
var colorBorder = "#ffffff";
var rectAnimationDuration = 50;
var centerLogo;
var portValue = resolveGetParam("port");
var highestLength = 0;

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

var welcomeNodeArray;
var sortedNodes = [];
var selectedCategory = "all-category";
GetDashboardWizards();
loadDisableWelcomePageParameter();
function loadWelcomeNodes(contributionsString) {
    var contributions = JSON.parse(contributionsString);
    var welcomeNodes = [];
    contributions.forEach(function (contribution) {
        var welcomeNode = {};
        welcomeNode.title = contribution.name;
        // welcomeNode.title = welcomeNode.title.split(/ /g)[0];
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
            wizardNode.parent = welcomeNode;
            welcomeNode.nodes.push(wizardNode);
            sortedNodes[wizard.priority] = wizardNode;
        });
        welcomeNodes.push(welcomeNode);
    });
    welcomeNodeArray = welcomeNodes;
    drawWelcomeNodes();
}

var categoryList = {
	    "routing-category": "Routing_Templates",
	    "messaging-category":"Messaging_Templates",
	    "msg-transformation-category" : "Transformation_Templates",
	    "data-category" : "DataIntegration_Templates",
	    "container-category" : "Container_Templates",
	    "error-category" : "ErrorHandling_Templates",
	    "test-category" : "Testing_Templates",
	    "saas-category" : "SaaS_Templates",
	    "task-category" : "Task_Templates"
};

var sampleMediatorList = {
	    "hello world service": "api,payload-factory,respond",
	    "proxying a soap service": "proxy,log,call,address-endpoint,respond",
	    "content based routing": "api,log,switch,payload-factory,header,call,property,respond,address-endpoint",
	    "header based routing": "api,payload-factory,log,switch,header,call,respond,address-endpoint",
	    "message filtering": "api,log,property,filter,respond,payload-factory,http-endpoint",
	    "protocol switching": "api,log,property,send,address-endpoint",
	    "scatter gather integration pattern": "api,aggregate,clone,send,header,address-endpoint",
	    "file transfer": "inbound-endpoint,sequence,log",
	    "guaranteed delivery": "api,property,message-store,http-endpoint,message-processor,sequence,filter,payload-factory,log,drop",
	    "jms integration": "api,log,property,send,address-endpoint,inbound-endpoint,sequence",
	    "rabbitmq integration": "proxy,log,property,send,address-endpoint,inbound-endpoint,sequence",
	    "kafka consumer and producer": "api,kafka,payload-factory,property,respond,inbound-endpoint,proxy,sequence,log,connector",
	    "rest to soap conversion": "api,payload-factory,header,property,send,enrich,address-endpoint",
	    "xml to json transformation": "api,payload-factory,send,http-endpoint",
	    "json to xml mapping": "api,datamapper,respond",
	    "xml to json mapping": "api,datamapper,respond",
	    "students data service": "dataservice,database,soap",
	    "rest data service": "dataservice,database,rest",
	    "exception handling": "api,send,http-endpoint,sequence,log,payload-factory,respond",
	    "fetch salesforce accounts": "api,salesforcerest,respond,connector",
	    "periodical scheduled tasks": "scheduled-task,sequence,call,log,address-endpoint",
	    "database polling": "scheduled-task,sequence,dataservice,address-endpoint,log,header,payload-factory,call",
	    "proxying a rest service": "api,log,call,http-endpoint,respond",
	    "hello docker": "docker,api,payload-factory,respond",
	    "hello kubernetes": "kubernetes,k8,api,payload-factory,respond",
	    "unit test tutorial": "testing,unit,api,sequence,switch,payload-factory,respond,log,drop",
	    "api testing": "test,api,property,payload-factory,respond,unit",
	    "email service": "email,connector,api,respond,foreach,payload-factory,property,log"
};

var esbNewProjectWizard = "org.wso2.developerstudio.eclipse.artifact.newesbsolutionproject";
var projectExportWizard = "org.wso2.developerstudio.eclipse.distribution.importAsArtifact";

var dataSourceProject = "org.wso2.developerstudio.eclipse.artifact.newdatasourceproject";
var dataServiceProject = "org.wso2.developerstudio.eclipse.artifact.newdsproject";

$("#DataServiceProject").click(function(){
	openWizard(dataServiceProject);
}); 

$("#DataSourceProject").click(function(){
	openWizard(dataSourceProject);
});

var BPMNProject = "org.wso2.developerstudio.bpmn.wizards.CreateBPMNProjectWizard";
var HumanTaskProject = "org.wso2.developerstudio.humantaskeditor.wizards.HumanTaskProjectWizard";

$("#BPMNProject").click(function(){
	openWizard(BPMNProject);
}); 

$("#HumanTaskProject").click(function(){
	openWizard(HumanTaskProject);
});

var mavenWizard = "org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard";
var serverWizard = 'org.eclipse.wst.server.ui.new.server';
var mediatorWizard = 'org.wso2.developerstudio.eclipse.artifact.newmediatorartifact';

$("#MavenMultiModuleProject").click(function(){
	openWizard(mavenWizard);
});

$("#Server").click(function(){
	openWizard(serverWizard);
});

$("#MediatorProject").click(function(){
	openWizard(mediatorWizard);
});

$("#createNewProject").click(function(){
	// OpenIDEWizard(esbNewProjectWizard);
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

function drawWelcomeNodes(){
	sortedNodes.forEach(function (childNode) {
		escapedChildTitle = childNode.title.replace(/\./g, '');		
		templateNode = createTemplateNode(escapedChildTitle, childNode.label, childNode.description, childNode.image, childNode.parent.title);
		$("#esb-templates").append(templateNode);
		$("#"+escapedChildTitle).click(function(){
			openWizard(childNode.wizardID);
	    });
	});
}

function createTemplateNode(templateID, templateName, templateDescription, image, category){
	if(image != null || image != "") {
		resolvedimage = "src='./images/template_thumb.jpg'";
	} else {
		resolvedimage = "src='data:image/png;base64, " + image + "'";
	}

	var categoryIconPath = "assets/img/icons/categories/";
	var imageFileName = category + ".png";

	if (templateName === "Hello World Service") {
		imageFileName = "Hello_World" + ".png";
	}

	var html = "<div class='col-xs-6 col-sm-4 col-md-4 col-lg-3 col-xl-2 template' data-title='" + templateName + "' data-category=' " + category + "'>" +
			"<div class='item-box' style='cursor: pointer;' id='" + templateID + "'><a class='mb-2' style='text-align: center; height: 25%;'><img src='" + categoryIconPath + imageFileName +"' style='width:40%; max-width: 120px'/></a><div style='width:100%'><a><h6 class='template-title' style='font-weight:600 !important; text-align:center;font-size:15px; margin-top:6px;'>" + templateName + "</h6></a></div>" +
			"<div class='item-box-inner' style='max-height:90px; height:90px; width: 100%; overflow-y: hidden;'><p style='font-weight:lighter;'>" + templateDescription + "</p></div></div></div>";

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
        	if (selectedCategory == "all-category" || selectedCategory == undefined) {
            	resetLoadTemplates();
            } else {
            	loadTemplatesByCategory(selectedCategory);
            }
        } else {
            $(templateList + ' > .template').each(function(){
                var text = $(this).attr("data-title").toLowerCase();
                var category = $(this).attr("data-category").toLowerCase();
                if (selectedCategory == "all-category" || selectedCategory == undefined) {
                	 (text.indexOf(valThis) >= 0 || sampleMediatorList[text].indexOf(valThis) >= 0) ? $(this).show() : $(this).hide();
                } else {
                	 ((text.indexOf(valThis) >= 0 || sampleMediatorList[text].indexOf(valThis) >= 0) 
                			 && (category.indexOf(selectedCategory.toLowerCase()) >= 0)) ? $(this).show() : $(this).hide();
                }
            });
        };
    });
}

// filter by category
$("#routing-category").click(function(){
	loadTemplatesByCategory("Routing_Templates");
	document.getElementById('search').value = '';
});

$("#messaging-category").click(function(){
	loadTemplatesByCategory("Messaging_Templates");
	document.getElementById('search').value = '';
});

$("#msg-transformation-category").click(function(){
	loadTemplatesByCategory("Transformation_Templates");
	document.getElementById('search').value = '';
});

$("#data-category").click(function(){
	loadTemplatesByCategory("DataIntegration_Templates");
	document.getElementById('search').value = '';
});

$("#container-category").click(function(){
	loadTemplatesByCategory("Container_Templates");
	document.getElementById('search').value = '';
});

$("#error-category").click(function(){
	loadTemplatesByCategory("ErrorHandling_Templates");
	document.getElementById('search').value = '';
});

$("#test-category").click(function(){
	loadTemplatesByCategory("Testing_Templates");
	document.getElementById('search').value = '';
});

$("#saas-category").click(function(){
	loadTemplatesByCategory("SaaS_Templates");
	document.getElementById('search').value = '';
});

$("#task-category").click(function(){
	loadTemplatesByCategory("Task_Templates");
	document.getElementById('search').value = '';
});

$("#all-category").click(function(){
	resetLoadTemplates();
	document.getElementById('search').value = '';
});

$(".dropdown-menu .menu-item a").click(function () {
     $(".dropdown-menu li > a").removeClass("active"); 
     $(this).closest("li > a").addClass("active");
     selectedCategory = categoryList[this.id];
     var displayCategory;
     if (selectedCategory == "all-category" || selectedCategory == undefined) {
         displayCategory = "Category";
     } else {
         displayCategory = $(this).text();
     }
     $("#dropdownMenuLink").text(displayCategory);
 });

$("#doc-link").click(function() {
	$.post("http://127.0.0.1:" + portValue + "/servlet/openbrowser", { link: "documentation" }, function(data, status){
    });
});

$("#git-link").click(function() {
	$.post("http://127.0.0.1:" + portValue + "/servlet/openbrowser", { link: "github" }, function(data, status){
    });
});

$("#slack-link").click(function() {
	$.post("http://127.0.0.1:" + portValue + "/servlet/openbrowser", { link: "slack" }, function(data, status){
    });
});

$("#video-link").click(function() {
	$.post("http://127.0.0.1:" + portValue + "/servlet/openbrowser", { link: "video" }, function(data, status){
    });
});

function loadTemplatesByCategory(category) {
	$('.template-list > .template').each(function(){
        var text = $(this).attr("data-category").toLowerCase();
        (text.indexOf(category.toLowerCase()) >= 0) ? $(this).show() : $(this).hide();
    });
}

function resetLoadTemplates() {
	$('.template-list > .template').each(function(){
		$(this).show(); 
    });
	selectedCategory = "all-category";
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

    var screenHeight = window.innerHeight;
    var topHeight = document.getElementById('left-top-section').clientHeight;
    var helpSectionHeight = document.getElementById("help-bottom-section").clientHeight;
    var helpSection = document.getElementById("help-bottom-section");

    if (screenHeight - 20 < topHeight + helpSectionHeight) {
    	helpSection.style.visibility = "hidden";
    } else {
    	helpSection.style.visibility = "visible";
    }
});

$(window).resize(function() {
    var screenHeight = window.innerHeight;
    var topHeight = document.getElementById('left-top-section').clientHeight;
    var helpSectionHeight = document.getElementById("help-bottom-section").clientHeight;
    var helpSection = document.getElementById("help-bottom-section");

    if (screenHeight - 20 < topHeight + helpSectionHeight) {
    	helpSection.style.visibility = "hidden";
    } else {
    	helpSection.style.visibility = "visible";
    }
 });
