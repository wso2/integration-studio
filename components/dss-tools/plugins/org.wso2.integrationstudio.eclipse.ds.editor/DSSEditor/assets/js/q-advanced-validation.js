/**
 * Set up elements for query advanced properties while initializing.
 */
$(document).ready(function() {
	clearQueryAdvancedProperties();
});

function clearQueryAdvancedProperties() {
	$('#q-timeout-input').val("");
	$('#q-fetchdir-select').val("");
	$('#q-adv-fetchsize-input').val("");
	$('#q-adv-max-field-size-input').val("");
	$('#q-adv-maxrows-input').val("");
	$('#q-adv-forcestoredproc-select').val("");
	$('#q-adv-forcejdbcbatchreq-select').val("");
}

function populateQueryAdvancedProperties() {
	let properties = window.queryElement.getElementsByTagName("properties");
	if (properties != null && properties != undefined && properties[0] != undefined && ((properties[0].children != undefined && properties[0].children.length > 0) 
			|| (properties[0].childNodes != undefined && properties[0].childNodes.length > 0))) {
		let propertyChildren = properties[0].children;
		if (propertyChildren == undefined) {
			propertyChildren = properties[0].childNodes;
		}
		$.each(propertyChildren, function (index, child) {
			if (child.attributes != null && child.attributes != undefined) {
				let name = child.attributes.getNamedItem("name").value;
				let value = child.innerHTML;
				if (value == undefined) {
					value = child.textContent;
				}
				if (value == undefined) {
					value = child.textContent;
				}
				if (name == "queryTimeout") {
					setQueryTimeout(value);
					
				} else if (name == "fetchDirection") {
					setFetchDirection(value);
					
				} else if (name == "forceStoredProc") {
					setForceStoredProc(value);
					
				} else if (name == "forceJDBCBatchRequests") {
					setForceJDBCBatchRequests(value);
					
				} else if (name == "fetchSize") {
					setFetchSize(value);
					
				} else if (name == "maxFieldSize") {
					setMaxFieldSize(value);
					
				} else if (name == "maxRows") {
					setMaxRows(value);
				}
			}
		});
	}
}

function setQueryTimeout(value) {
	$('#q-timeout-input').val(value);
}

function setFetchDirection(value) {
	if (value.toLowerCase() == "forward") {
		$('#q-fetchdir-select').val("forward");
	} else if (value.toLowerCase() == "reverse") {
		$('#q-fetchdir-select').val("reverse");
	} else {
		$('#q-fetchdir-select').val("");
	}
}

function setFetchSize(value) {
	$('#q-adv-fetchsize-input').val(value);
}

function setMaxFieldSize(value) {
	$('#q-adv-max-field-size-input').val(value);
}

function setMaxRows(value) {
	$('#q-adv-maxrows-input').val(value);
}

function setForceStoredProc(value) {
	if (value.toLowerCase() == "true") {
		$('#q-adv-forcestoredproc-select').val("true");
	} else if (value.toLowerCase() == "false") {
		$('#q-adv-forcestoredproc-select').val("false");
	} else {
		$('#q-adv-forcestoredproc-select').val("");
	}
}

function setForceJDBCBatchRequests(value) {
	if (value.toLowerCase() == "true") {
		$('#q-adv-forcejdbcbatchreq-select').val("true");
	} else if (value.toLowerCase() == "false") {
		$('#q-adv-forcejdbcbatchreq-select').val("false");
	} else {
		$('#q-adv-forcejdbcbatchreq-select').val("");
	}
}

function createPropertiesObject(root) {
	let propertiesElement = root.createElement("properties");
	
	let queryTimeout = $('#q-timeout-input').val();
	if ($.trim(queryTimeout) != "") {
		propertiesElement.appendChild(getProperty(root, "queryTimeout", queryTimeout));
	}
	
	let fetchDirection = $('#q-fetchdir-select').val();
	if ($.trim(fetchDirection) != "") {
		propertiesElement.appendChild(getProperty(root, "fetchDirection", fetchDirection));
	}
	
	let fetchSize = $('#q-adv-fetchsize-input').val();
	if ($.trim(fetchSize) != "") {
		propertiesElement.appendChild(getProperty(root, "fetchSize", fetchSize));
	}
	
	let maxFieldSize = $('#q-adv-max-field-size-input').val();
	if ($.trim(maxFieldSize) != "") {
		propertiesElement.appendChild(getProperty(root, "maxFieldSize", maxFieldSize));
	}
	
	let maxRows = $('#q-adv-maxrows-input').val();
	if ($.trim(maxRows) != "") {
		propertiesElement.appendChild(getProperty(root, "maxRows", maxRows));
	}
	
	let forceStoredProc = $('#q-adv-forcestoredproc-select').val();
	if ($.trim(forceStoredProc) != "") {
		propertiesElement.appendChild(getProperty(root, "forceStoredProc", forceStoredProc));
	}
	
	let forceJDBCBatchRequests = $('#q-adv-forcejdbcbatchreq-select').val();
	if ($.trim(forceJDBCBatchRequests) != "") {
		propertiesElement.appendChild(getProperty(root, "forceJDBCBatchRequests", forceJDBCBatchRequests));
	}
	
	if ((propertiesElement.children != undefined && propertiesElement.children.length > 0) || (propertiesElement.childNodes != undefined && propertiesElement.childNodes.length > 0)) {
		return propertiesElement;
	} else {
		return null;
	}
}

function getProperty(root, name, value) {
	let propertyElement = root.createElement("property");
	propertyElement.setAttribute("name", name);
	if (propertyElement.innerHTML != undefined) {
		propertyElement.innerHTML = value;
	} else if (propertyElement.textContent != undefined) {
		propertyElement.textContent = value;
	}
	return propertyElement;
}

function replacePropertiesInQuery(root, queryElement) {
	let props = queryElement.getElementsByTagName("properties");
	if (props.length == 1) {
		query.removeChild(props[0]);
	}
	let propertiesElement = createPropertiesObject(root);
	if (propertiesElement != null) {
		queryElement.appendChild(propertiesElement);
	}
	
	return queryElement;
}