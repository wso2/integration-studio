/**
 * Set up elements for query output mapping modal while initializing.
 */
$(document).ready(function() {
	//populate ui elements according to outputType
	populateOutputTypeElements();

});

/**
 * Populates query parameters upon query id changes.
 */
$('#om-outputtype-select').change(function(e) {
	e.preventDefault();
	populateOutputTypeElements();
});

$('#q-om-addedit-paramtype-select').change(function(e) {
	let paramType = $('#q-om-addedit-paramtype-select').val();
	if (paramType == 'array') {
		$('#q-om-addedit-arrayname-inputgroup').toggle(true);
	} else {
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
	}
	
});

$('#q-om-addedit-dsmapping-select').change(function(e) {
	let qParamType = $('#q-om-addedit-dsmapping-select').val();
	if (qParamType == 'column') {
		$('#q-om-addedit-dscolname-inputgroup').toggle(true);
		$('#q-om-addedit-qparamname-inputgroup').toggle(false);
	} else {
		$('#q-om-addedit-dscolname-inputgroup').toggle(false);
		$('#q-om-addedit-qparamname-inputgroup').toggle(true);
	}
});

$('#q-output_mapping-add-btn').click(function(e) {
	clearOutputMappingModal();
	
	$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
	$('#q-om-addedit-outputfn-inputgroup').toggle(true);
	$('#q-om-addedit-elename-inputgroup').toggle(false);
	$('#q-om-addedit-elens-inputgroup').toggle(true);
	$('#q-om-addedit-dscolname-inputgroup').toggle(true);
	$('#q-om-addedit-qparamname-inputgroup').toggle(false);
	$('#q-om-addedit-paramtype-inputgroup').toggle(true);
	$('#q-om-addedit-arrayname-inputgroup').toggle(false);
	$('#q-om-addedit-schematype-inputgroup').toggle(true);
	$('#q-om-addedit-optional-inputgroup').toggle(true);
	$('#q-om-addedit-export-inputgroup').toggle(true);
	$('#q-om-addedit-selectquery-inputgroup').toggle(false);
	$('#q-om-query-entries-tbl').toggle(false);
});

function populateOutputTypeElements() {
	let outputType = $("#om-outputtype-select").val(); 
	
	if (outputType == 'xml') {
		$('#om-grouped-by-element-inputgroup').toggle(true);
		$('#om-row-name-inputgroup').toggle(true);
		$('#om-rdf-baseuri-inputgroup').toggle(false);
		$('#om-row-namespace-inputgroup').toggle(true);
		$('#om-xslt-path-inputgroup').toggle(true);
		$('#om-json-inputgroup').toggle(false);
		$('#q-om-queries-table').toggle(true);
		
	} else if (outputType == 'rdf') {
		$('#om-grouped-by-element-inputgroup').toggle(false);
		$('#om-row-name-inputgroup').toggle(false);
		$('#om-rdf-baseuri-inputgroup').toggle(true);
		$('#om-row-namespace-inputgroup').toggle(true);
		$('#om-xslt-path-inputgroup').toggle(true);
		$('#om-json-inputgroup').toggle(false);
		$('#q-om-queries-table').toggle(true);
		
	} else if (outputType == 'json') {
		$('#om-grouped-by-element-inputgroup').toggle(false);
		$('#om-row-name-inputgroup').toggle(false);
		$('#om-rdf-baseuri-inputgroup').toggle(false);
		$('#om-row-namespace-inputgroup').toggle(false);
		$('#om-xslt-path-inputgroup').toggle(false);
		$('#om-json-inputgroup').toggle(true);
		$('#q-om-queries-table').toggle(false);
		
	}
}

function populateOueryOutputMappings(queryElement) {
	let resultElement = queryElement.getElementsByTagName("result");
	if (resultElement.length > 0) {
		
		let escapeNonPrintableChar = resultElement[0].attributes.getNamedItem("escapeNonPrintableChar");
		if (escapeNonPrintableChar != null && escapeNonPrintableChar != undefined && escapeNonPrintableChar.value == "true") {
			$('#om-escapse-npc-checkbox').prop("checked", true);
		} else {
			$('#om-escapse-npc-checkbox').prop("checked", false);
		}
		
		let useColumnNumbers = resultElement[0].attributes.getNamedItem("useColumnNumbers");
		if (useColumnNumbers != null && useColumnNumbers != undefined && useColumnNumbers.value == "true") {
			$('#om-use-column-nums-checkbox').prop("checked", true);
		} else {
			$('#om-use-column-nums-checkbox').prop("checked", false);
		}
		
		let outputType = resultElement[0].attributes.getNamedItem("outputType");
		if (outputType != null && outputType != undefined && outputType.value.toLowerCase() == "rdf") {
			$('#om-outputtype-select').val('rdf');
			
			let rdfBaseURI = resultElement[0].attributes.getNamedItem("rdfBaseURI");
			if (rdfBaseURI != null && rdfBaseURI != undefined) {
				$('#om-rdf-baseuri-input').val(rdfBaseURI.value);
			}
			
			let defaultNamespace = resultElement[0].attributes.getNamedItem("defaultNamespace");
			if (defaultNamespace != null && defaultNamespace != undefined) {
				$('#om-row-namespace-input').val(defaultNamespace.value);
			}
			
			let xsltPath = resultElement[0].attributes.getNamedItem("xsltPath");
			if (xsltPath != null && xsltPath != undefined) {
				$('#om-xslt-path-input').val(xsltPath.value);
			}
			
		} else if (outputType != null && outputType != undefined && outputType.value.toLowerCase() == "json") {
			$('#om-outputtype-select').val('json');
			
			if (resultElement[0].textContent != undefined) {
				$('#om-json-input').val(resultElement[0].textContent);
			}
			
		} else {
			$('#om-outputtype-select').val('xml');
			let element = resultElement[0].attributes.getNamedItem("element");
			if (element != null && element != undefined) {
				$('#om-grouped-by-element-input').val(element.value);
			}
			
			let rowName = resultElement[0].attributes.getNamedItem("rowName");
			if (rowName != null && rowName != undefined) {
				$('#om-row-name-input').val(rowName.value);
			}
			
			let defaultNamespace = resultElement[0].attributes.getNamedItem("defaultNamespace");
			if (defaultNamespace != null && defaultNamespace != undefined) {
				$('#om-row-namespace-input').val(defaultNamespace.value);
			}
			
			let xsltPath = resultElement[0].attributes.getNamedItem("xsltPath");
			if (xsltPath != null && xsltPath != undefined) {
				$('#om-xslt-path-input').val(xsltPath.value);
			}
		}
		
		$('#q-output-mapping-table').find('tbody').find('tr').detach();
		let elements = resultElement[0].getElementsByTagName('element');
		$.each(elements, function(index, el) {
			let nameVal, columnVal, xsdTypeVal, requiredRolesVal, datasourceTypeVal = "";
			let mappingTypeVal = "element";
			
			let column = el.attributes.getNamedItem("column");
			if (column != undefined) {
				columnVal = column.value;
			}
			
			let name = el.attributes.getNamedItem("name");
			if (name != undefined) {
				nameVal = name.value;
			}
			
			let xsdType = el.attributes.getNamedItem("xsdType");
			if (xsdType != undefined) {
				xsdTypeVal = xsdType.value;
			}
			
//			let arrayName = el.attributes.getNamedItem("arrayName");
//			if (arrayName != undefined) {
//				
//			}
//			
//			let exportAttribute = el.attributes.getNamedItem("export");
//			
//			let exportType = el.attributes.getNamedItem("exportType");
//			
//			let namespace = el.attributes.getNamedItem("namespace");
//			
//			let optional = el.attributes.getNamedItem("optional");
			
			let query_param = el.attributes.getNamedItem("query-param");
			if (query_param != undefined && query_param != null) {
				datasourceTypeVal = "query-param";
			} else {
				datasourceTypeVal = "column";
			}
			
			let requiredRoles = el.attributes.getNamedItem("requiredRoles");
			if (requiredRoles != undefined) {
				requiredRolesVal = requiredRoles.value;
			} else {
				requiredRolesVal = "N/A";
			}
			
			let row = "<tr><td>" + nameVal + "</td><td>" + datasourceTypeVal + "</td><td>" + columnVal + "</td><td>" + mappingTypeVal + "</td><td>" + requiredRolesVal + "</td><td>" + xsdTypeVal + "</td><td class=\"text-center\"><i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td></tr>";
			$('#q-output-mapping-table > tbody').append(row);
		
		});
	}
}

function populateQueryOutputMappingModal(root, firstCol, secondCol) {
	$("#q-output-mapping-modal").modal('show');
}

function deleteQueryOutputMappingFromRoot(root, firstCol) {
	
}

function clearOutputMappingForm() {
	$('#om-outputtype-select').val('xml');
	$('#om-escapse-npc-checkbox').prop("checked", false);
	$('#om-use-column-nums-checkbox').prop("checked", false);
	$('#om-rdf-baseuri-input').val("");
	$('#om-row-namespace-input').val("");
	$('#om-xslt-path-input').val("");
	$('#om-json-input').val("");
	$('#om-grouped-by-element-input').val("");
	$('#om-row-name-input').val("");
	$('#om-row-namespace-input').val("");
	$('#q-output-mapping-table').find('tbody').find('tr').detach();
}

function populateOutputMappingModal(root) {
	let mappingType = $('#q-om-addedit-mappingtype-select').val();
	if (mappingType == "element") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		$('#q-om-addedit-outputfn-inputgroup').toggle(true);
		$('#q-om-addedit-elename-inputgroup').toggle(false);
		$('#q-om-addedit-elens-inputgroup').toggle(true);
		$('#q-om-addedit-dscolname-inputgroup').toggle(true);
		$('#q-om-addedit-qparamname-inputgroup').toggle(false);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(true);
		$('#q-om-addedit-optional-inputgroup').toggle(true);
		$('#q-om-addedit-export-inputgroup').toggle(true);
		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
		$('#q-om-query-entries-tbl').toggle(false);
		
	} else if (mappingType == "attribute") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		$('#q-om-addedit-outputfn-inputgroup').toggle(true);
		$('#q-om-addedit-elename-inputgroup').toggle(false);
		$('#q-om-addedit-elens-inputgroup').toggle(false);
		$('#q-om-addedit-dscolname-inputgroup').toggle(true);
		$('#q-om-addedit-qparamname-inputgroup').toggle(false);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(true);
		$('#q-om-addedit-optional-inputgroup').toggle(true);
		$('#q-om-addedit-export-inputgroup').toggle(true);
		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
		$('#q-om-query-entries-tbl').toggle(false);
		
	} else if (mappingType == "query") {
		populateQueriesForOutputMappingParamForm(root);
		
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(false);
		$('#q-om-addedit-outputfn-inputgroup').toggle(false);
		$('#q-om-addedit-elename-inputgroup').toggle(false);
		$('#q-om-addedit-elens-inputgroup').toggle(false);
		$('#q-om-addedit-dscolname-inputgroup').toggle(false);
		$('#q-om-addedit-qparamname-inputgroup').toggle(false);
		$('#q-om-addedit-paramtype-inputgroup').toggle(false);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(false);
		$('#q-om-addedit-optional-inputgroup').toggle(false);
		$('#q-om-addedit-export-inputgroup').toggle(false);
		$('#q-om-addedit-selectquery-inputgroup').toggle(true);
		$('#q-om-query-entries-tbl').toggle(false);
		
	} else if (mappingType == "complex-element") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(false);
		$('#q-om-addedit-outputfn-inputgroup').toggle(false);
		$('#q-om-addedit-elename-inputgroup').toggle(true);
		$('#q-om-addedit-elens-inputgroup').toggle(true);
		$('#q-om-addedit-dscolname-inputgroup').toggle(false);
		$('#q-om-addedit-qparamname-inputgroup').toggle(false);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(false);
		$('#q-om-addedit-optional-inputgroup').toggle(false);
		$('#q-om-addedit-export-inputgroup').toggle(false);
		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
		$('#q-om-query-entries-tbl').toggle(false);
	}
}

function clearOutputMappingModal() {
	$('#q-om-addedit-mappingtype-select').val('element');
	$('#q-om-addedit-dsmapping-select').val('column');
	$('#q-om-addedit-outputfn-input').val("");
	$('#q-om-addedit-elename-input').val("");
	$('#q-om-addedit-elens-input').val("");
	$('#q-om-addedit-dscolname-input').val("");
	$('#q-om-addedit-qparamname-input').val("");
	$('#q-om-addedit-paramtype-select').val("scalar");
	$('#q-om-addedit-arrayname-input').val("");
	$('#q-im-paramtype-select').val("string");
	$('#q-om-addedit-optional-checkbox').prop("checked", false);
	$('#q-export-name-input').val("");
	$('#q-export-type-select').val("scalar");
	$('#q-om-addedit-query-select').val("");
	$('#q-om-query-table').find('tbody').find('tr').detach();
	$('#role-admin-checkbox').prop("checked", false);
	$('#role-int-checkbox').prop("checked", false);
}

function processOutputMappingModal(root) {
	//TODO add to table
	let dataRoot = root.getElementsByTagName("data")[0];
	let eleName = '';
	let dsType = '';
	let colNumber = '';
	let mapType = '';
	let uRoles = '';
	let schType = '';
	
	let dsTypeSelect = $('#q-om-addedit-dsmapping-select').val();
	if (dsTypeSelect == "query-param") {
		dsType = "query-param";
	} else {
		dsType = "column";
	}
	
	let mappingType = $('#q-om-addedit-mappingtype-select').val();
	if (mappingType == "element") {
		mapType = "element";
		
		let element = root.createElement("element");
		
		eleName = appendNameAttribute(element);
		appendElementNS(element);
		colNumber = appendDSTypeAttribute(element);
		appendParameterTypeAttribute(element);
		schType = appendSchemaTypeAttribute(element);
		appendOptionalAttribute(element);
		appendExportAttribute(element);
		uRoles = appendUserRolesAttribute(element);
	    
		appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType);
	    return element;
	    
	} else if (mappingType == "attribute") {
		mapType = "attribute";
		
		let attribute = root.createElement("attribute");
		
		eleName = appendNameAttribute(attribute);
		colNumber = appendDSTypeAttribute(attribute);
		appendParameterTypeAttribute(attribute);
		schType = appendSchemaTypeAttribute(attribute);
		appendOptionalAttribute(attribute);
		appendExportAttribute(attribute);
		uRoles = appendUserRolesAttribute(attribute);
		
		appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType);
		
		return attribute;
		
	} else if (mappingType == "query") {
		mapType = "query";
		
		let call_query = root.createElement("call-query");
		
		let query_id = $('#q-om-addedit-query-select').val();
		call_query.setAttribute("href", query_id);
		
		let op_parameters = $('#q-om-query-table > tbody').find('tr');
	    $.each(op_parameters, function(index, op_parameter) {
			let withparamElement = root.createElement("with-param");
			withparamElement.setAttribute("name", op_parameter.cells[0].firstChild.textContent);
			let mappingType = op_parameter.cells[2].firstChild.value;
			if (mappingType == "column") {
				withparamElement.setAttribute("column", op_parameter.cells[1].firstChild.value);
			} else {
				withparamElement.setAttribute("query-param", op_parameter.cells[1].firstChild.value);
			}
			call_query.appendChild(withparamElement);
		});
		
	    uRoles = appendUserRolesAttribute(call_query);
	    
	    appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType);
	    
	    return call_query;
		
	} else if (mappingType == "complex-element") {
		
		mapType = "complex-element";
//		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(false);
//		$('#q-om-addedit-outputfn-inputgroup').toggle(false);
//		$('#q-om-addedit-elename-inputgroup').toggle(true);
//		$('#q-om-addedit-elens-inputgroup').toggle(true);
//		$('#q-om-addedit-dscolname-inputgroup').toggle(false);
//		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
//		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
//		$('#q-om-addedit-schematype-inputgroup').toggle(false);
//		$('#q-om-addedit-optional-inputgroup').toggle(false);
//		$('#q-om-addedit-export-inputgroup').toggle(false);
//		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
//		$('#q-om-query-entries-tbl').toggle(false);
	}
	
	
	
}

function appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType) {
	let om_row = '<tr><td>' + eleName + '</td><td>' + dsType + '</td><td>' + colNumber + '</td><td>' + mapType + '</td><td>' + uRoles + '</td><td>' + schType + '</td><td class="text-center"><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td></tr>';
	$('#q-output-mapping-table > tbody').append(om_row);
}

function appendUserRolesAttribute(element) {
	let requiredRoles = "";
	let hasAdminRole = false;
	if ($('#role-admin-checkbox').is(":checked")) {
		requiredRoles = "admin";
		hasAdminRole = true;
    }
	if ($('#role-int-checkbox').is(":checked")) {
		if (hasAdminRole) {
			requiredRoles = requiredRoles + ",";
		}
		requiredRoles = requiredRoles + "Internal/everyone";
    }
	element.setAttribute("requiredRoles", requiredRoles);
	if (requiredRoles == "") {
		requiredRoles = "N/A";
	}
	return requiredRoles;
}

function appendNameAttribute(element) {
	let outputFiledName = $('#q-om-addedit-outputfn-input').val();
	if ($.trim(outputFiledName) != "") {
		element.setAttribute("name", outputFiledName);
	} else {
		return "";
	}
	return outputFiledName;
}

function appendElementNS(element) {
	let elementNS = $('#q-om-addedit-elens-input').val();
	if ($.trim(elementNS) != "") {
		element.setAttribute("namespace", elementNS);
	}
}

function appendDSTypeAttribute(element) {
	let dsType = $('#q-om-addedit-dsmapping-select').val();
	if (dsType == "query-param") {
		let qParamName = $('#q-om-addedit-qparamname-input').val();
		if ($.trim(qParamName) != "") {
			element.setAttribute("query-param", qParamName);
			return qParamName;
		} else {
			return "";
		}
		
	} else {
		//dsType is column
		let dSColumnName = $('#q-om-addedit-dscolname-input').val();
		if ($.trim(dSColumnName) != "") {
			element.setAttribute("column", dSColumnName);
			return dSColumnName;
		} else {
			return "";
		}
	}
}

function appendParameterTypeAttribute(element) {
	let paramType = $('#q-om-addedit-paramtype-select').val();
	if (paramType == "array") {
		let arrayName = $('#q-om-addedit-arrayname-input').val();
		element.setAttribute("arrayName", arrayName);
	}
}

function appendSchemaTypeAttribute(element) {
	let schemaType = $('#q-om-paramtype-select').val();
	element.setAttribute("xsdType", schemaType);
	return schemaType;
}

function appendOptionalAttribute(element) {
	if ($('#q-om-addedit-optional-checkbox').is(":checked")) {
    	element.setAttribute("optional", true);
    }
}

function appendExportAttribute(element) {
	let exportName = $('#q-export-name-input').val();
    if ($.trim(exportName) != "") {
    	element.setAttribute("export", exportName);
    	
    	let exportType = $('#q-export-type-select').val();
    	if (exportType == "array") {
    		element.setAttribute("exportType", exportType);
    	}
    }
}

/**
 * Populates query list.
 * 
 * @param root Root document
 */
function populateQueriesForOutputMappingParamForm(root) {
	let select = $('#q-om-addedit-query-select');
	select.find("option").detach();
	let option = new Option("-- Select Query --", "", true, "");
	select.append(option);
	let queries = root.getElementsByTagName("query");
	
	$.each(queries, function (index, query) {
		let query_id = query.attributes.getNamedItem("id").value;
		select.append(new Option(query_id));
	});
}

/**
 * Populates query output mapping parameters table.
 * 
 * @param root Root document
 * @param queryid Query id
 */
function populateQueryOutputMappingParamaterTable(root, queryid) {
		
	$('#q-om-query-table').find('tbody').find('tr').detach();
	
	if (queryid != "") {
    	
    	let queries = root.getElementsByTagName("query");
    	for (let i = 0, len = queries.length; i < len; i++) {
    		var query_id = queries[i].attributes.getNamedItem("id").value;
    		
    		if (queryid == query_id) {
    			let params = queries[i].getElementsByTagName("param");
    			
            	if (params.length > 0) {
            		$('#q-om-query-entries-tbl').toggle(true);
            	} else {
            		$('#q-om-query-entries-tbl').toggle(false);
            	}
            	
        		$.each(params, function (i, param) {
        			let paramName = param.attributes.getNamedItem("name").value;
        			
        			let row = "<tr><td>" + paramName + "</td><td><input class=\"form-control\" type=\"text\" value=\"" + paramName + "\" placeholder=\"Mapping_Name_Placeholder\" " 
        				+ " style=\"width: 100%;\"></td><td><select class=\"form-control\" required=\"\" id=\"q-om-mapping-type-select\" style=\"margin-left: 10px;\"><option " 
        				+ "value=\"column\" selected=\"\">Column</option><option value=\"query-param\">Query Param</option></select></td></tr>";
        			$('#q-om-query-table > tbody').append(row);
        			
        		});
    		}
    	}	
    	
	} else {
		$('#q-om-query-entries-tbl').toggle(false);
	}
}

function updateResultElement(root, result, element) {
	if (result == null || result == undefined) {
		result = root.createElement("result");
	}
	if (element.localName == "element" || element.localName == "attribute" || element.localName == "call-query") {
		appendElementsToResult(result, element);
	}
	
	return result;
}

function appendElementsToResult(result, element) {
	let existingElements = result.children;
	let exists = false;
	if (existingElements != undefined && existingElements.length > 0) {
		for (let i = 0, len = existingElements.length; i < len; i++) {
			if (existingElements[0].localName == element.localName && 
					((element.localName == "call-query" && existingElements[0].attributes.getNamedItem("href") != undefined && element.attributes.getNamedItem("href").value == existingElements[0].attributes.getNamedItem("href").value) 
					|| (existingElements[0].attributes.getNamedItem("name") != undefined && element.attributes.getNamedItem("name").value == existingElements[0].attributes.getNamedItem("name").value))) {
				exists = false;
				result.removeChild(existingElements[0]);
				result.appendChild(element);
			} else {
				let currentEle = existingElements[0];
				result.removeChild(existingElements[0]);
				result.appendChild(currentEle);
			}
		}
	} else {
		result.appendChild(element);
	}
	
	if (result.children.length > 0 && !exists) {
		result.appendChild(element);
	}
}

function saveResultToQueryElement(result, query) {
	//remove result if exists already
	let rslt = query.getElementsByTagName("result");
	if (rslt.length == 1) {
		query.removeChild(rslt[0]);
	}
	query.appendChild(result);
	console.log(query);
	return query;
}

function generateOutputMapping() {
	
}