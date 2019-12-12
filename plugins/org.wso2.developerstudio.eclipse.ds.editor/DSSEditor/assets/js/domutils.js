/**
 * This script contains utility functions related to DOM object manipulation.
 *
 */

/**
 * Creates an element in a given parent.
 *
 * @param root DOM object.
 * @param parent Parent node.
 * @param elementName Name of the element.
 */
function createElement(root, parent, elementName) {
    let element = root.createElement(elementName);
    parent.appendChild(element);
}

/**
 * Extracts query params from the URI.
 *
 * @param param Parameter name.
 * @returns {*} Value of the param.
 */
function resolveGetParam(param) {
    let paramValue = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
            tmp = item.split("=");
            if (tmp[0] === param) {
                paramValue = decodeURIComponent(tmp[1]);
            }
        });
    return paramValue;
}

/**
 * Parses XML text content into a DOM object.
 *
 * @param xmlTextContent XML content to be parsed.
 * @returns {Document} Document object.
 */
function parseXmlTextContent(xmlTextContent) {
    let root;
    try {
        let parser = new DOMParser();
        root = parser.parseFromString(xmlTextContent, "text/xml");
    } catch (err) {
        console.log("Error while parsing the document.", err);
    }

    return root;
}

/**
 * Returns an array of a string split by a given delimiter.
 *
 * @param str String to be split.
 * @param delimiter Delimiter to be split with.
 * @returns {string[]} Array of strings.
 */
function splitAndTrim(str, delimiter) {
    return str.split(delimiter).map((item)=>item.trim());
}

/**
 * Deletes a specific node from the DOM tree.
 *
 * @param root Document root object.
 * @param datasourceId Data source ID which should be deleted.
 */
function deleteDatasource(root, datasourceId) {
    let dsConfigs = root.getElementsByTagName("config");

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        if (dsConfigs[i].id == datasourceId) {
            // Delete the node.
            root.documentElement.removeChild(dsConfigs[i]);
        }
    }
}