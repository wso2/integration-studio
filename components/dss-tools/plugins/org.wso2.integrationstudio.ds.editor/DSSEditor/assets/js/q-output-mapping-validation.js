/**
 * Set up elements for query output mapping modal while initializing.
 */
$(document).ready(function() {
	//populate ui elements according to outputType
	populateOutputTypeElements();

});

var OUTPUT_ELEMENT_MAPPING_GENERATE_BTN = "#q-output_mapping-gen-btn";
var INPUT_ELEMENT_MAPPING_GENERATE_BTN = "#q-input-mapping-generate-btn";
var OUTPUT_ELEMENT_MAPPING_ADD_BTN = "#q-output_mapping-add-btn";
var SQL_QUERY_INPUT_LABEL = "#sql-query-label";
var DATA_SOURCE_SELECT = "#q-datasource-select";
var HIDDEN = "hidden";

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
	
	$('#output-mapping-modal-header').text("Add Output Mapping");
	let query_id = $('#q-query-id-input').val();
	if (query_id == undefined || query_id == null || $.trim(query_id) == "") {
		showQueryNotification("danger", "Query ID cannot be empty.", 1000);
		return false;
	}
	
	let datasource = $('#q-datasource-select').val();
	if (datasource == "") {
		showQueryNotification("danger", "Select a datasource.", 1000);
		return false;
	}
	
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
	$('#q-om-complex-child-inputgroup').toggle(false);
});

/*
 * Toggle between input groups according to the datasource type.
 */
function toggleBetweenDataSourceTypes() {
	let qParamType = $('#q-om-addedit-dsmapping-select').val();
	let isColumn = (qParamType == 'column');
	$('#q-om-addedit-dscolname-inputgroup').toggle(isColumn);
	$('#q-om-addedit-qparamname-inputgroup').toggle(!isColumn);
}

function populateOutputTypeElements() {
	let outputType = $("#om-outputtype-select").val(); 
	
	// Making Add and Generate buttons visible.
	// Make generate button visible only if data source is not mongoDB.
	if (!isMongoDB($(DATA_SOURCE_SELECT).val())) {
		$(OUTPUT_ELEMENT_MAPPING_GENERATE_BTN).prop(HIDDEN, false);
	}
	$(OUTPUT_ELEMENT_MAPPING_ADD_BTN).prop(HIDDEN, false);
	
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
		
		// Hiding Add and Generate buttons if output type is JSON.
		$(OUTPUT_ELEMENT_MAPPING_GENERATE_BTN).prop(HIDDEN, true);
		$(OUTPUT_ELEMENT_MAPPING_ADD_BTN).prop(HIDDEN, true);
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
		
		//populate elements into the table		
		if ($('#om-outputtype-select').val() != "json") {
			let childNodes = resultElement[0].children;
			if (childNodes == undefined) {
				childNodes = resultElement[0].childNodes;
			}
			$.each(childNodes, function(index, ele) {
				let nameVal;
				let columnVal = "";
				let xsdTypeVal = "";
				let requiredRolesVal = "";
				let datasourceTypeVal = "";
				let mappingTypeVal = "";
				
				if (ele.localName != null && ele.localName != undefined) {
					if (ele.localName == "attribute") {
						mappingTypeVal = "attribute";
						nameVal = getElementNameColumnValue(ele);
						datasourceTypeVal = getDSTypeColumnValue(ele);
						columnVal = getColumnNameColumnValue(ele);
						xsdTypeVal = getSchemaTypeColumnValue(ele);
						
					} else if (ele.localName == "call-query") {
						mappingTypeVal = "query";
						nameVal = getElementNameColumnValueForQuery(ele);
						
					} else if (ele.localName == "element") {

						if ((ele.children != undefined && ele.children.length > 0) || (ele.childNodes != undefined && ele.childNodes.length > 0)) {
							mappingTypeVal = "complex-element";
						} else {
							mappingTypeVal = "element";
							datasourceTypeVal = getDSTypeColumnValue(ele);
							columnVal = getColumnNameColumnValue(ele);
							xsdTypeVal = getSchemaTypeColumnValue(ele);
						}
						
						nameVal = getElementNameColumnValue(ele);
					}
					
					let requiredRoles = ele.attributes.getNamedItem("requiredRoles");
					if (requiredRoles != undefined) {
						requiredRolesVal = requiredRoles.value;
					} else {
						requiredRolesVal = "N/A";
					}
					
					let row = "<tr><td>" + nameVal + "</td><td>" + datasourceTypeVal + "</td><td>" + columnVal + "</td><td>" + mappingTypeVal + "</td><td>" + requiredRolesVal + "</td><td>" + xsdTypeVal + "</td><td class=\"text-center\"><i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td></tr>";
					$('#q-output-mapping-table > tbody').append(row);
				}
			
			});
		}
		populateOutputTypeElements();
		return resultElement[0];
		
	} else {
		clearOutputMappingForm();
		populateOutputTypeElements();
		return null;
	}
}

function getElementNameColumnValue(el) {
	let name = el.attributes.getNamedItem("name");
	if (name != undefined) {
		return name.value;
	} else {
		return "";
	}
}

function getElementNameColumnValueForQuery(el) {
	let name = el.attributes.getNamedItem("href");
	if (name != undefined) {
		return name.value;
	} else {
		return "";
	}
}

function getDSTypeColumnValue(el) {
	let query_param = el.attributes.getNamedItem("query-param");
	if (query_param != undefined && query_param != null) {
		return "query-param";
	} else {
		return "column";
	}
}

function getColumnNameColumnValue(el) {
	let column = el.attributes.getNamedItem("column");
	if (column != undefined) {
		return column.value;
	} else {
		return "";
	}
}

function getSchemaTypeColumnValue(el) {
	let xsdType = el.attributes.getNamedItem("xsdType");
	if (xsdType != undefined) {
		return xsdType.value;
	} else {
		return "";
	}
}

function populateQueryOutputMappingModal(result, tds, root) {
	
	let mappingType = tds[3].innerText;
	if (mappingType == "element" || mappingType == "complex-element") {
		populateElementModal(result, tds);
		populateOutputMappingModal(root, true);
		
	} else if (mappingType == "attribute") {
		populateAttributeModal(result, tds);
		populateOutputMappingModal(root, true);
		
	} else if (mappingType == "query") {
		populateQueryModal(result, tds, root);
		populateOutputMappingModal(root, false);
	}
	
	$("#q-output-mapping-modal").modal({backdrop: 'static', show: false});
	$("#q-output-mapping-modal").modal('show');
}

function populateElementModal(result, tds) {
	 let eles = result.getElementsByTagName("element");
	 for (let i = 0, len = eles.length; i < len; i++) {
		 let ele = eles[i];
		 let name = ele.attributes.getNamedItem("name").value;
		 if (name == tds[0].innerText) {
			 let dsType = tds[1].innerText;
			 if (dsType == "column") {
				 $('#q-om-addedit-mappingtype-select').val('element');
				 $('#q-om-addedit-dsmapping-select').val('column');
				 $('#q-om-addedit-outputfn-input').val(name);
				 setNamespaceValues(ele);
				 
				 $('#q-om-addedit-dscolname-input').val(getAttributeValue(ele, 'column'));
				 setParamaterTypeValues(ele);
				 let paramTypeVal = tds[5].innerText;
				 if (paramTypeVal.indexOf(":") != -1) {
					 let values = paramTypeVal.split(":");
					 $('#q-om-paramtype-select').val(values[1]);
				 } else {
					 $('#q-om-paramtype-select').val(paramTypeVal);
				 }
				 
				 setOptionalValue(ele);
				 setExportValues(ele);
				 setRoleValues(ele);
				 
				 break;
				 
			 } else if (dsType == "query-param") {
				 $('#q-om-addedit-mappingtype-select').val('element');
				 $('#q-om-addedit-dsmapping-select').val('query-param');
				 $('#q-om-addedit-outputfn-input').val(name);
				 setNamespaceValues(ele);
				 $('#q-om-addedit-qparamname-input').val(getAttributeValue(ele, "query-param"));
				 setParamaterTypeValues(ele);
				 $('#q-om-paramtype-select').val(tds[5].innerText);
				 setOptionalValue(ele);
				 setExportValues(ele);
				 setRoleValues(ele);
				 
				 break;
				 
			 } else if (dsType == "" && tds[5].innerText == "") {
				 //complex element
				 $('#q-om-addedit-mappingtype-select').val('complex-element');
				 $('#q-om-addedit-elename-input').val(name);
				 setNamespaceValues(ele);
				 setParamaterTypeValues(ele);
				 
				 let childValue = "";
				 let childs = ele.children;
				 if (childs == undefined) {
					 childs = ele.childNodes;
				 }
				 $.each(childs, function(index, child) {
					 childValue = childValue + child.outerHTML;
				 });
				 $('#om-complex-child-input').val(childValue);
				 
				 setRoleValues(ele);
				 
				 break;
			 }
		}
	}
}

/*
 * Validate attribute and returns attribute value.
 */
function getAttributeValue(element, attributeName) {
	let attribute = element.attributes.getNamedItem(attributeName);
	if (attribute != null && attribute != undefined) {
		return attribute.value;
	}
	return EMPTY_STRING;
}

function setNamespaceValues(ele) {
	let ns = ele.attributes.getNamedItem("namespace");
	if (ns != null && ns != undefined) {
		$('#q-om-addedit-elens-input').val(ns.value);
	}
}

function setRoleValues(ele) {
	if (ele.attributes.getNamedItem("requiredRoles") != null) {
		let roles = ele.attributes.getNamedItem("requiredRoles").value;
		if (roles.indexOf("admin") != -1) {
			$('#role-admin-checkbox').prop("checked", true);
			
		} else {
			$('#role-admin-checkbox').prop("checked", false);
		}
		
		if (roles.indexOf("Internal/everyone") != -1) {
			$('#role-int-checkbox').prop("checked", true);
		} else {
			$('#role-int-checkbox').prop("checked", false);
		}
	}
}

function setExportValues(ele) {
	if (ele.attributes.getNamedItem("export") != null) {
		$('#q-export-name-input').val(ele.attributes.getNamedItem("export").value);
	} else {
		$('#q-export-name-input').val("");
	}
	
	if (ele.attributes.getNamedItem("exportType") != null && ele.attributes.getNamedItem("exportType").value.toLowerCase() == "array") {
		$('#q-export-type-select').val("array");
	} else {
		$('#q-export-type-select').val("scalar");
	}
}

function setParamaterTypeValues(ele) {
	if (ele.attributes.getNamedItem("arrayName") != null) {
		 $('#q-om-addedit-paramtype-select').val("array");
		 $('#q-om-addedit-arrayname-input').val(ele.attributes.getNamedItem("arrayName").value);
		 
	 } else {
		 $('#q-om-addedit-paramtype-select').val("scalar");
		 
	 }
}

function setOptionalValue(ele) {
	if (ele.attributes.getNamedItem("optional") != null && ele.attributes.getNamedItem("optional").value == "true") {
		$('#q-om-addedit-optional-checkbox').prop("checked", true);
	} else {
		$('#q-om-addedit-optional-checkbox').prop("checked", false);
	}
}

function populateAttributeModal(result, tds) {
	let attributes = result.getElementsByTagName("attribute");
	$('#q-om-addedit-mappingtype-select').val('attribute');
	 for (let i = 0, len = attributes.length; i < len; i++) {
		 let attribute = attributes[i];
		 let name = attribute.attributes.getNamedItem("name").value;
		 if (name == tds[0].innerText) {
			 $('#q-om-addedit-outputfn-input').val(name);
			 setParamaterTypeValues(attribute);
			 setOptionalValue(attribute);
			 setExportValues(attribute);
			 setRoleValues(attribute);
			 $('#q-om-paramtype-select').val(tds[5].innerText);
			 
			 let dsType = tds[1].innerText;
			 if (dsType == "column" && attribute.attributes.getNamedItem("column") != null) {
				 $('#q-om-addedit-dsmapping-select').val('column');
				 $('#q-om-addedit-dscolname-input').val(attribute.attributes.getNamedItem("column").value);
				 
				 break;
				 
			 } else if (dsType == "query-param" && attribute.attributes.getNamedItem("query-param") != null) {
				 $('#q-om-addedit-dsmapping-select').val('query-param');
				 $('#q-om-addedit-qparamname-input').val(attribute.attributes.getNamedItem("query-param").value);
				 
				 break;
				 
			 }
		}
	}
}

function populateQueryModal(result, tds, root) {
	let queries = result.getElementsByTagName("call-query");
	$('#q-om-addedit-mappingtype-select').val('query');
	 for (let i = 0, len = queries.length; i < len; i++) {
		 let query = queries[i];
		 let href = query.attributes.getNamedItem("href").value;
		 
		 if (href == tds[0].innerText) {
			 populateQueriesForOutputMappingParamForm(root);
			 $('#q-om-addedit-query-select').val(href);
			 let params = query.getElementsByTagName("with-param");
			 
			 $('#q-om-query-table').find('tbody').find('tr').detach();
			 $.each(params, function(index, param) {
				 let row = "";
				 if (param.attributes.getNamedItem("column") != null) {
					 row = "<tr><td>" + param.attributes.getNamedItem("name").value + "</td><td><input class=\"form-control\" type=\"text\" value=\"" + param.attributes.getNamedItem("column").value + "\" placeholder=\"Mapping_Name_Placeholder\" " 
				       + " style=\"width: 100%;\"></td><td><select class=\"form-control\" required=\"\" id=\"q-om-mapping-type-select\" style=\"margin-left: 10px;\"><option " 
				       + "value=\"column\" selected=\"\">Column</option><option value=\"query-param\">Query Param</option></select></td></tr>";
				 } else if (param.attributes.getNamedItem("query-param") != null) {
					 row = "<tr><td>" + param.attributes.getNamedItem("name").value + "</td><td><input class=\"form-control\" type=\"text\" value=\"" + param.attributes.getNamedItem("query-param").value + "\" placeholder=\"Mapping_Name_Placeholder\" " 
				       + " style=\"width: 100%;\"></td><td><select class=\"form-control\" required=\"\" id=\"q-om-mapping-type-select\" style=\"margin-left: 10px;\"><option " 
				       + "value=\"column\">Column</option><option value=\"query-param\" selected=\"\">Query Param</option></select></td></tr>";
				 }
				 
				 $('#q-om-query-table > tbody').append(row);
			 });
			 
			 if (params.length > 0) {
				 $('#q-om-query-entries-tbl').toggle(true);
			 } else {
				 $('#q-om-query-entries-tbl').toggle(false);
			 }
			 setRoleValues(query);
			 break;
		}
	}
}

function deleteQueryOutputMappingFromResult(result, tds) {
	let name = tds[0].innerText;
	let mappingType = tds[3].innerText;
	if (mappingType == "element" || mappingType == "complex-element") {
		let eles = result.getElementsByTagName("element");
		for (let i = 0, len = eles.length; i < len; i++) {
			if (name == eles[i].attributes.getNamedItem("name").value) {
				 result.removeChild(eles[i]);
				 break;
			 }
		}
		
	} else if (mappingType == "attribute") {
		let attributes = result.getElementsByTagName("attribute");
		for (let i = 0, len = attributes.length; i < len; i++) {
			if (name == attributes[i].attributes.getNamedItem("name").value) {
				 result.removeChild(attributes[i]);
				 break;
			 }
		}
		
	} else if (mappingType == "query") {
		let queries = result.getElementsByTagName("call-query");
		for (let i = 0, len = queries.length; i < len; i++) {
			 if (name == queries[i].attributes.getNamedItem("href").value) {
				 result.removeChild(queries[i]);
				 break;
			 }
		}
	}
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

function populateOutputMappingModal(root, populateQueries) {
	let mappingType = $('#q-om-addedit-mappingtype-select').val();
	if (mappingType == "element") {
		toggleBetweenDataSourceTypes();
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		$('#q-om-addedit-outputfn-inputgroup').toggle(true);
		$('#q-om-addedit-elename-inputgroup').toggle(false);
		$('#q-om-addedit-elens-inputgroup').toggle(true);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(true);
		$('#q-om-addedit-optional-inputgroup').toggle(true);
		$('#q-om-addedit-export-inputgroup').toggle(true);
		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
		$('#q-om-query-entries-tbl').toggle(false);
		$('#q-om-complex-child-inputgroup').toggle(false);
		
	} else if (mappingType == "attribute") {
		toggleBetweenDataSourceTypes();
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		$('#q-om-addedit-outputfn-inputgroup').toggle(true);
		$('#q-om-addedit-elename-inputgroup').toggle(false);
		$('#q-om-addedit-elens-inputgroup').toggle(false);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-arrayname-inputgroup').toggle(false);
		$('#q-om-addedit-schematype-inputgroup').toggle(true);
		$('#q-om-addedit-optional-inputgroup').toggle(true);
		$('#q-om-addedit-export-inputgroup').toggle(true);
		$('#q-om-addedit-selectquery-inputgroup').toggle(false);
		$('#q-om-query-entries-tbl').toggle(false);
		$('#q-om-complex-child-inputgroup').toggle(false);
		
	} else if (mappingType == "query") {
		if (populateQueries) {
			$('#q-om-query-entries-tbl').toggle(false);
			populateQueriesForOutputMappingParamForm(root);
		}
		
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
		$('#q-om-complex-child-inputgroup').toggle(false);
		
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
		$('#q-om-complex-child-inputgroup').toggle(true);
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
	$('#om-complex-child-input').val("");
}

function processOutputMappingModal(root) {
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
		dsType = "";
		
		let call_query = root.createElement("call-query");
		
		let query_id = $('#q-om-addedit-query-select').val();
		eleName = query_id;
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
		
		let cElement = root.createElement("element");
		eleName = appendElementNameAttribute(cElement);
		dsType = "";
		appendElementNS(cElement);
		appendParameterTypeAttribute(cElement);
		let childText = $('#om-complex-child-input').val();
		let childObjects = $(childText);
		
		$.each(childObjects, function(index, child) {
			cElement.appendChild(child);
		});
		
		uRoles = appendUserRolesAttribute(cElement);
		
		appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType);
		
		return cElement;
	}
	
}

function appendToOutMappingTable(eleName, dsType, colNumber, mapType, uRoles, schType) {
	
	let exists = false;
	let trs = $('#q-output-mapping-table').find('tr');
  	for (let i = 0; i < trs.length; i++) {
  		if (eleName == trs[i].cells[0].firstChild.textContent) {
  			exists = true;
  			trs[i].cells[1].textContent = dsType;
  			trs[i].cells[2].textContent = colNumber;
  			trs[i].cells[3].textContent = mapType;
  			trs[i].cells[4].textContent = uRoles;
  			trs[i].cells[5].textContent = schType;
  		}
  	}
  	
  	if (!exists) {
  		let om_row = '<tr><td>' + eleName + '</td><td>' + dsType + '</td><td>' + colNumber + '</td><td>' + mapType + '</td><td>' + uRoles + '</td><td>' + schType + '</td><td class="text-center"><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td></tr>';
  		$('#q-output-mapping-table > tbody').append(om_row);
  	}
}

function appendElementNameAttribute(element) {
	let elementName = $('#q-om-addedit-elename-input').val();
	if ($.trim(elementName) != "") {
		element.setAttribute("name", elementName);
	} else {
		return "";
	}
	return elementName;
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
		result = appendElementsToResult(result, element);
	}
	
	return result;
}

function appendElementsToResult(result, element) {
	
	let isEdit = $('#output-mapping-modal-header').text() == "Edit Output Mapping";
	let originalResult = result;
	
	let existingElements = result.children;
	if (existingElements == undefined) {
		existingElements = result.childNodes;
	}
	let exists = false;
	if (existingElements != undefined && existingElements.length > 0) {
		for (let i = 0, len = existingElements.length; i < len; i++) {
			if (existingElements[0].localName == element.localName && 
					((element.localName == "call-query" && existingElements[0].attributes.getNamedItem("href") != undefined && element.attributes.getNamedItem("href").value == existingElements[0].attributes.getNamedItem("href").value) 
					|| (existingElements[0].attributes.getNamedItem("name") != undefined && element.attributes.getNamedItem("name").value == existingElements[0].attributes.getNamedItem("name").value))) {
				exists = true;
				if (!isEdit) {
					showOutputMappingNotification("danger", "Output mapping with this identifier already exists.", 4000);
					return originalResult;
				}
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
	
	if (((result.children != null && result.children.length > 0) || (result.childNodes != null && result.childNodes.length > 0)) && !exists) {
		result.appendChild(element);
	}
	
	$("#q-output-mapping-modal").modal('hide');
	return result;
}

function saveResultToQueryElement(result, root) {
	
	if ($('#om-use-column-nums-checkbox').is(":checked")) {
		result.setAttribute("useColumnNumbers", "true");
	} else {
		result.removeAttribute("useColumnNumbers");
	}
	
	if ($('#om-escapse-npc-checkbox').is(":checked")) {
		result.setAttribute("escapeNonPrintableChar", "true");
	} else {
		result.removeAttribute("escapeNonPrintableChar");
	}
	
	let outputType = $("#om-outputtype-select").val(); 
	
	if (outputType == 'xml') {
		let elementName = $('#om-grouped-by-element-input').val();
		if ($.trim(elementName) != "") {
			result.setAttribute("element", elementName);
		} else if (result.attributes.getNamedItem(RESULT_ATTRIBUTE_ELEMENT) != null) {
			result.removeAttribute(RESULT_ATTRIBUTE_ELEMENT);
		}
		
		let rowName = $('#om-row-name-input').val();
		if ($.trim(rowName) != "") {
			result.setAttribute("rowName", rowName);
		} else if (result.attributes.getNamedItem(RESULT_ATTRIBUTE_ROW_NAME) != null) {
			result.removeAttribute(RESULT_ATTRIBUTE_ROW_NAME);
		}
		
		let defaultNamespace = $('#om-row-namespace-input').val();
		if ($.trim(defaultNamespace) != "") {
			result.setAttribute("defaultNamespace", defaultNamespace);
		} else if (result.attributes.getNamedItem(RESULT_ATTRIBUTE_DEF_NAME_SPACE) != null) {
			result.removeAttribute(RESULT_ATTRIBUTE_DEF_NAME_SPACE);
		}
		
		let xsltPath = $('#om-xslt-path-input').val();
		if ($.trim(xsltPath) != "") {
			result.setAttribute("xsltPath", xsltPath);
		} else if (result.attributes.getNamedItem(RESULT_ATTRIBUTE_XSLT_PATH) != null) {
			result.removeAttribute(RESULT_ATTRIBUTE_XSLT_PATH);
		}
		
		result.removeAttribute("rdfBaseURI");
		
	} else if (outputType == 'rdf') {
		result.removeAttribute("element");
		result.removeAttribute("rowName");
		
		let defaultNamespace = $('#om-row-namespace-input').val();
		if ($.trim(defaultNamespace) != "") {
			result.setAttribute("defaultNamespace", defaultNamespace);
		}
		
		let xsltPath = $('#om-xslt-path-input').val();
		if ($.trim(xsltPath) != "") {
			result.setAttribute("xsltPath", xsltPath);
		}
		
		let rdfBaseURI = $('#om-rdf-baseuri-input').val();
		if ($.trim(rdfBaseURI) != "") {
			result.setAttribute("rdfBaseURI", rdfBaseURI);
		}
		
		result.setAttribute("outputType", "rdf");
		
	} else if (outputType == 'json') {
		result.removeAttribute("element");
		result.removeAttribute("rowName");
		result.removeAttribute("defaultNamespace");
		result.removeAttribute("xsltPath");
		result.removeAttribute("rdfBaseURI");
		
		result.setAttribute("outputType", "json");
		
		let childElements = result.children;
		if (childElements == undefined) {
			childElements = result.childNodes;
		}
		if (childElements.length > 0) {
			while (result.hasChildNodes()) {
				result.removeChild(result.firstChild);
			}
		}
		let jsonInput = $('#om-json-input').val();
		let text_node = root.createTextNode(jsonInput);
		result.appendChild(text_node);
	}

	return result;
}

function generateOutputMapping(root, portValue) {
	let result = null;
	let query = $('#q-sql-query-input').val();
	if ($.trim(query) == "") {
		showQueryNotification("danger", "Please enter the query before generating the output mapping.", 1000);
		return false;
	}
	
	if ((query.toLowerCase().indexOf("insert") != -1 && query.toLowerCase().indexOf("into") != -1) || (query.toLowerCase().indexOf("update", 0) != -1)) {
		return false;
	}
	
	let mappings = query.substring(query.toLowerCase().lastIndexOf("select") + 6, query.toLowerCase().lastIndexOf("from"));
	let mappingValues = mappings.split(",");
	
	$('#q-output-mapping-table').find('tbody').find('tr').detach();
	
	let generated = false;
	
	if (mappingValues.length == 1) {
		if ($.trim(mappingValues[0]) == "*") {
			generated = true;
			let datasourceName = $('#q-datasource-select').val();
			let configs = root.getElementsByTagName("config");
			let connectionUrl = "";
			let username = "";
			let password = "";
			
			if (configs.length > 0) {
				for (let i = 0, len = configs.length; i < len; i++) {
					let identifier = configs[i].attributes.getNamedItem("id").value;
					if (identifier == datasourceName) {
						let properties = configs[i].getElementsByTagName("property");
						$.each(properties, function (j, property) {
							let name = property.attributes.getNamedItem("name").value.toLowerCase();
							if ($.trim(name).indexOf("user") != -1) {
								username = property.textContent;
							} else if ($.trim(name).indexOf("password") != -1) {
								password = property.textContent;
							} else if ($.trim(name).indexOf("protocol") != -1 || $.trim(name).indexOf("url") != -1) {
								connectionUrl = property.textContent;
							}
						});
						break;
					}
				}
			}
			let credentials = username + ":" + password;
			if (portValue == null || portValue == undefined) {
				portValue = "7774";
			}
			url = "http://127.0.0.1:" + portValue + "/dsseditor/service";
			result =  getMappings(connectionUrl, query, credentials, url, root);
		}
	}
	
	if (!generated && mappingValues.length > 0) {
		result = root.createElement("result");
		
		$.each(mappingValues, function (i, val) {
			let name = $.trim(val);
			result = addGeneratedMappingsToRoot(root, result, name);
		});
	}
	
	return result;
}

function addGeneratedMappingsToRoot(root, result, name) {
	let element = root.createElement("element");
	element.setAttribute("name", name);
	element.setAttribute("column", name);
	element.setAttribute("xsdType", "string");
	result.appendChild(element);
	
	addGeneratedMappingsToTable(name);
	
	return result;
}

function addGeneratedMappingsToTable(name) {
	let row = "<tr><td>" + name + "</td><td>column</td><td>" + name + "</td><td>element</td><td>N/A</td><td>string</td><td class=\"text-center\"><i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td></tr>";
	$('#q-output-mapping-table > tbody').append(row);
}

/**
 * Shows an alert of a given type in the output mapping editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showOutputMappingNotification(type, message, interval) {
    let alertHtml = "<div id='q-om-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#q-om-notification-alert-holder").html(alertHtml);
    $("#q-om-notification-alert").show();

    showAlert("q-om-notification-alert", interval);
}

function replaceResultInQuery(resultElement) {
	let rslt = window.queryElement.getElementsByTagName("result");
	if (rslt.length == 1) {
		query.removeChild(rslt[0]);
	}
	// Add results element only if it has any attribute or child.
	if (resultElement != null && resultElement != undefined 
			&& (resultElement.attributes.length > 0 || resultElement.childNodes.length > 0)) {
		window.queryElement.appendChild(resultElement);
	}
	
	return window.queryElement;
}
