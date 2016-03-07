/**
 * Created by kavith on 1/21/15.
 */
var viewTask = function(taskname) {
	$(".task_view").not("#task_" + taskname).hide();
	$("#task_" + taskname).show("Blind");
}

var viewTaskPeopleGroups = function() {
	$("#task-view-all").hide();
	$("#task-view-people-group").show("Blind");
	$("#task-view-tasks").hide();
	$("#task-view-notifications").hide();
}

var viewTasks = function() {
	$("#task-view-all").hide();
	$("#task-view-people-group").hide();
	$("#task-view-tasks").show("Blind");
	$("#task-view-notifications").hide();
}

var viewNotifications = function() {
	$("#task-view-all").hide();
	$("#task-view-people-group").hide();
	$("#task-view-tasks").hide();
	$("#task-view-notifications").show("Blind");
}
