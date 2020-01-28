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

$('#q-om-addedit-mappingtype-select').change(function(e) {
	e.preventDefault();
	populateOutputMappingModal();
});

$('#q-input_mapping-add-btn').click(function (e) {
	console.log("log add");
	clearOutputMappingModal();
	populateOutputMappingModal();
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

function populateOutputMappingModal() {
	let mappingType = $('#q-om-addedit-mappingtype-select').val();
	if (mappingType == "element") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		$('#q-om-addedit-outputfn-inputgroup').toggle(true);
		$('#q-om-addedit-elens-inputgroup').toggle(true);
		$('#q-om-addedit-dscolname-inputgroup').toggle(true);
		$('#q-om-addedit-paramtype-inputgroup').toggle(true);
		$('#q-om-addedit-schematype-inputgroup').toggle(true);
		$('#q-om-addedit-optional-inputgroup').toggle(true);
		
	} else if (mappingType == "attribute") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(true);
		
	} else if (mappingType == "query") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(false);
		
	} else if (mappingType == "complex-element") {
		$('#q-om-addedit-dsmapping-select-inputgroup').toggle(false);
	}
}

function clearOutputMappingModal() {
	
}

