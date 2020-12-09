// This function will take a JSON schema as input and
// generate a sample JSON payload as output.
function traverseObject(obj, parentObj, badgerFishCompliant) {
  if ("type" in obj) {
    var type = obj["type"].trim();
    switch (type) {
      case "boolean":
        {
          parentObj = true;
          break;
        }
      case "number" :
      case "integer":
        {
          parentObj = 1234;
          break;
        }
      case "float":
        {
          parentObj = 1.618;
          break;
        }
      case "string":
        {
          parentObj = "Sample String";
          break;
        }
      case "array":
        {
          return processArray(obj, badgerFishCompliant);
        }
      case "object":
        {
			var attributes = obj["attributes"];
			var properties = obj["properties"];

			// resolve attributes seperately
			for ( var attrkey in attributes) {
				attributes[attrkey] = traverseObject(attributes[attrkey],
						attributes, badgerFishCompliant);
			}

			for ( var attrkey in attributes) {
				if (badgerFishCompliant) {
					properties["@" + attrkey] = attributes[attrkey];
				} else {
					properties[attrkey] = attributes[attrkey];
				}
			}

			delete obj["required"];
			for ( var key in properties) {
				if (typeof properties[key] == "object")
					properties[key] = traverseObject(properties[key],
							properties, badgerFishCompliant);
			}
			// replace the main object at the end
			return properties;
		}
    }
  } else {
    for (var key in obj) {
      obj[key] = traverseObject(obj[key],obj,badgerFishCompliant);
    }
  }
  return parentObj;
}

// process an Array object
function processArray(obj, badgerFishCompliant) {
  var itemsObj = obj["items"];
  var tempArr = [];
  if (Array.isArray(itemsObj)) {
    itemsObj.forEach(function(element) {
      tempArr.push(traverseObject(element,obj,badgerFishCompliant));
    });
    parentObj = tempArr;
  } else {
    var arrType = itemsObj["type"];
    switch (arrType) {
      case "boolean":
        {
          parentObj = [true, false];
          break;
        }
      case "number" :
      case "integer":
        {
          parentObj = [1234, 5678];
          break;
        }
      case "float":
        {
          parentObj = [1.618, 3.14];
          break;
        }
      case "string":
        {
          parentObj = ["Sample1", "sample2"];
          break;
        }
    }
  }
  return parentObj;
}

function convertSchemaToJson(schema, badgerFishCompliant) {
	  var rootValue = schema["title"];
	  var result = traverseObject(schema, schema, badgerFishCompliant);
	  if(rootValue != "root"){
	    var newResult = new Object();
	    newResult[rootValue.toString()] = result;
	    result = newResult;
	  }
	  return result;
}


