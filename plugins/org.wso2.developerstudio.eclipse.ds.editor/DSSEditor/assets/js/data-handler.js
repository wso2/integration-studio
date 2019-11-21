$(document).ready(function ($) {

    // var portValue = resolveGetParam("port");
    // var url = "http://localhost:" + portValue + "/dsseditor/service";

    var dummyXml = "<data name=\"StudentDataService\" serviceGroup=\"\" " +
        "serviceNamespace=\"http://mynamespace.com/blah\" transports=\"http, https\">\n" +
        "    <description>sample description</description>\n" +
        "    <config id=\"StudentsDatasource\">\n" +
        "        <property name=\"org.wso2.ws.dataservice.user\">user</property>\n" +
        "        <property name=\"org.wso2.ws.dataservice.password\">password</property>\n" +
        "        <property name=\"org.wso2.ws.dataservice.protocol\">jdbc:mysql://localhost:3306/school_db</property>\n" +
        "        <property name=\"org.wso2.ws.dataservice.driver\">com.mysql.jdbc.Driver</property>\n" +
        "    </config>\n" +
        "    <query id=\"CreateStudents\" useConfig=\"StudentsDatasource\">\n" +
        "        <sql>INSERT INTO students (name, school, grade) VALUES (:name, :school, :grade)</sql>\n" +
        "        <param name=\"name\" paramType=\"SCALAR\" sqlType=\"STRING\"/>\n" +
        "        <param name=\"school\" paramType=\"SCALAR\" sqlType=\"STRING\"/>\n" +
        "        <param name=\"grade\" paramType=\"SCALAR\" sqlType=\"INTEGER\"/>\n" +
        "    </query>\n" +
        "    <query id=\"UpdateStudents\" useConfig=\"StudentsDatasource\">\n" +
        "        <sql>UPDATE students SET name = :name, school = :school, grade = :grade WHERE id = :id</sql>\n" +
        "        <param name=\"name\" paramType=\"SCALAR\" sqlType=\"STRING\"/>\n" +
        "        <param name=\"school\" paramType=\"SCALAR\" sqlType=\"STRING\"/>\n" +
        "        <param name=\"grade\" paramType=\"SCALAR\" sqlType=\"INTEGER\"/>\n" +
        "        <param name=\"id\" paramType=\"SCALAR\" sqlType=\"INTEGER\"/>\n" +
        "    </query>\n" +
        "    <query id=\"ReadStudents\" useConfig=\"StudentsDatasource\">\n" +
        "        <sql>SELECT id, name, school, grade FROM students</sql>\n" +
        "        <result element=\"Students\" rowName=\"Student\">\n" +
        "            <element column=\"id\" name=\"Id\" xsdType=\"xs:integer\"/>\n" +
        "            <element column=\"name\" name=\"Name\" xsdType=\"xs:string\"/>\n" +
        "            <element column=\"school\" name=\"School\" xsdType=\"xs:string\"/>\n" +
        "            <element column=\"grade\" name=\"Grade\" xsdType=\"xs:integer\"/>\n" +
        "        </result>\n" +
        "    </query>\n" +
        "    <query id=\"DeleteStudent\" useConfig=\"StudentsDatasource\">\n" +
        "        <sql>DELETE FROM students WHERE id = :id</sql>\n" +
        "        <param name=\"id\" paramType=\"SCALAR\" sqlType=\"INTEGER\"/>\n" +
        "    </query>\n" +
        "    <operation name=\"CreateStudents\">\n" +
        "        <call-query href=\"CreateStudents\">\n" +
        "            <with-param name=\"name\" query-param=\"name\"/>\n" +
        "            <with-param name=\"school\" query-param=\"school\"/>\n" +
        "            <with-param name=\"grade\" query-param=\"grade\"/>\n" +
        "        </call-query>\n" +
        "    </operation>\n" +
        "    <operation name=\"UpdateStudents\">\n" +
        "        <call-query href=\"UpdateStudents\">\n" +
        "            <with-param name=\"name\" query-param=\"name\"/>\n" +
        "            <with-param name=\"school\" query-param=\"school\"/>\n" +
        "            <with-param name=\"grade\" query-param=\"grade\"/>\n" +
        "            <with-param name=\"id\" query-param=\"id\"/>\n" +
        "        </call-query>\n" +
        "    </operation>\n" +
        "    <operation name=\"ReadStudents\">\n" +
        "        <call-query href=\"ReadStudents\"/>\n" +
        "    </operation>\n" +
        "    <operation name=\"DeleteStudents\">\n" +
        "        <call-query href=\"DeleteStudent\">\n" +
        "            <with-param name=\"id\" query-param=\"id\"/>\n" +
        "        </call-query>\n" +
        "    </operation>\n" +
        "</data>\n";

    var url = "http://localhost:7774/dsseditor/service";

    // $.get(url, function (data, status) {
    //
    //     parser = new DOMParser();
    //     xmlDoc = parser.parseFromString(dummyXml, "text/xml");
    //
    //     $('#dss-name-header').text(xmlDoc.getElementsByTagName("data")[0].attributes.getNamedItem("name").value);
    //
    //
    //     var description = xmlDoc.getElementsByTagName("description")[0].nodeValue;
    //
    //     if (description != null) {
    //         $('#dss-description-input').val(description);
    //     }
    //
    //
    // });

    var root = parseXmlTextContent(dummyXml);

    populateGeneralDetails(root);
    populateTransportSettings(root);

    /** Start of Event handlers **/

    // Transport settings - Transports
    $("#ts-transport-check-row input").change(function () {
        var transportsStr = $('.ts-transport-checkbox:checked').map(function() {
            return this.name;
        }).get().join(',');

        root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value = transportsStr;
    });

    /** End of Event handlers **/

});


/**
 * Populates the UI with general DSS data.
 *
 * @param root Document object.
 */
function populateGeneralDetails(root) {
    $('#dss-name-header').text(root.getElementsByTagName("data")[0].attributes.getNamedItem("name").value);

    var description = root.getElementsByTagName("description")[0].childNodes[0].nodeValue;
    var namespace = root.getElementsByTagName("data")[0].attributes.getNamedItem("serviceNamespace").value;

    if (description) {
        $('#dss-description-input').val(description);
    }

    if (namespace) {
        $('#dss-namespace-input').val(namespace);
    }

}

/**
 * Populates Transport settings data.
 *
 * @param root Document object.
 */
function populateTransportSettings(root) {
    var transports = root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value;
    var transportValues;

    if (transports) {
        transportValues = transports.split(",");
        transportValues.forEach(function (item, index) {
            item = item.trim();
            if (item == "http") {
                $('#ts-http-check').prop('checked', true);
            } else if (item == "https") {
                $('#ts-https-check').prop('checked', true);
            } else if (item == "local") {
                $('#ts-local-check').prop('checked', true);
            } else if (item == "jms") {
                $('#ts-jms-check').prop('checked', true);
            }
        });
    }

}

//------------ Utility functions ----------- //
/**
 * Extracts query params from the URI.
 *
 * @param param Parameter name.
 * @returns {*} Value of the param.
 */
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

/**
 * Parses XML text content into a DOM object
 *
 * @param xmlTextContent XML content to be parsed.
 * @returns {Document} Document object.
 */
function parseXmlTextContent(xmlTextContent) {
    try {
        var parser = new DOMParser();
        var root = parser.parseFromString(xmlTextContent, "text/xml");
    } catch (err) {
        handleError("Parsing Error \n" + err.message);
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