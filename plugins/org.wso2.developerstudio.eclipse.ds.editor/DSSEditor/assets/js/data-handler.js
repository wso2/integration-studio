$(document).ready(function ($) {

    // var portValue = resolveGetParam("port");
    // var url = "http://localhost:" + portValue + "/dsseditor/service";

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });

    var dummyXml =
        "<data disableLegacyBoxcarringMode=\"true\" enableBatchRequests=\"true\" enableBoxcarring=\"true\" name=\"StudentDataService\" serviceNamespace=\"namespace\" transports=\"http https\">\n" +
        "   <description>sample description</description>\n" +
        "   <config enableOData=\"true\" id=\"StudentsDatasource\">\n" +
        "      <property name=\"username\">root</property>\n" +
        "      <property name=\"password\">root</property>\n" +
        "      <property name=\"url\">jdbc:mysql://localhost:3306/school_db</property>\n" +
        "      <property name=\"driverClassName\">com.mysql.jdbc.Driver</property>\n" +
        "      <property name=\"dynamicUserAuthClass\">dynauthclass</property>\n" +
        "      <property name=\"dynamicUserAuthMapping\">\n" +
        "         <configuration>\n" +
        "            <entry request=\"un\">\n" +
        "               <username>dbun</username>\n" +
        "               <password>passw</password>\n" +
        "            </entry>\n" +
        "         </configuration>\n" +
        "      </property>\n" +
        "   </config>\n" +
        "   <query id=\"CreateStudents\" useConfig=\"StudentsDatasource\">\n" +
        "      <sql>INSERT INTO students (name, school, grade) VALUES (:name, :school, :grade)</sql>\n" +
        "      <param name=\"name\" sqlType=\"STRING\"/>\n" +
        "      <param name=\"school\" sqlType=\"STRING\"/>\n" +
        "      <param name=\"grade\" sqlType=\"INTEGER\"/>\n" +
        "   </query>\n" +
        "   <query id=\"UpdateStudents\" useConfig=\"StudentsDatasource\">\n" +
        "      <sql>UPDATE students SET name = :name, school = :school, grade = :grade WHERE id = :id</sql>\n" +
        "      <param name=\"name\" sqlType=\"STRING\" type=\"OUT\"/>\n" +
        "      <param name=\"school\" sqlType=\"STRING\"/>\n" +
        "      <param name=\"grade\" sqlType=\"INTEGER\"/>\n" +
        "      <param name=\"id\" sqlType=\"INTEGER\"/>\n" +
        "   </query>\n" +
        "   <query id=\"ReadStudents\" useConfig=\"StudentsDatasource\">\n" +
        "      <sql>SELECT id, name, school, grade FROM students</sql>\n" +
        "      <result element=\"Students\" rowName=\"Student\">\n" +
        "         <element column=\"id\" name=\"Id\" xsdType=\"xs:integer\"/>\n" +
        "         <element column=\"name\" name=\"Name\" xsdType=\"xs:string\"/>\n" +
        "         <element column=\"school\" name=\"School\" xsdType=\"xs:string\"/>\n" +
        "         <element column=\"grade\" name=\"Grade\" xsdType=\"xs:integer\"/>\n" +
        "      </result>\n" +
        "   </query>\n" +
        "   <query id=\"DeleteStudent\" useConfig=\"StudentsDatasource\">\n" +
        "      <sql>DELETE FROM students WHERE id = :id</sql>\n" +
        "      <param name=\"id\" sqlType=\"INTEGER\"/>\n" +
        "   </query>\n" +
        "   <operation name=\"CreateStudents\">\n" +
        "      <call-query href=\"CreateStudents\">\n" +
        "         <with-param name=\"name\" query-param=\"name\"/>\n" +
        "         <with-param name=\"school\" query-param=\"school\"/>\n" +
        "         <with-param name=\"grade\" query-param=\"grade\"/>\n" +
        "      </call-query>\n" +
        "   </operation>\n" +
        "   <operation name=\"UpdateStudents\">\n" +
        "      <call-query href=\"UpdateStudents\">\n" +
        "         <with-param name=\"name\" query-param=\"name\"/>\n" +
        "         <with-param name=\"school\" query-param=\"school\"/>\n" +
        "         <with-param name=\"grade\" query-param=\"grade\"/>\n" +
        "         <with-param name=\"id\" query-param=\"id\"/>\n" +
        "      </call-query>\n" +
        "   </operation>\n" +
        "   <operation name=\"ReadStudents\">\n" +
        "      <call-query href=\"ReadStudents\" requiredRoles=\"\"/>\n" +
        "   </operation>\n" +
        "   <operation name=\"DeleteStudents\">\n" +
        "      <call-query href=\"DeleteStudent\">\n" +
        "         <with-param name=\"id\" query-param=\"id\"/>\n" +
        "      </call-query>\n" +
        "   </operation>\n" +
        "   <authorization_provider class=\"authproviderclass\">\n" +
        "      <property name=\"blah\">bleh</property>\n" +
        "   </authorization_provider>\n" +
        "</data>";

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
    populateDataSources(root);

    /** Start of Event handlers **/

    // Transport settings - Transports
    $("#ts-transport-check-row input").change(function () {
        var transportsStr = $('.ts-transport-checkbox:checked').map(function() {
            return this.name;
        }).get().join(' ');

        root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value = transportsStr;
    });

    // Data sources - Add data source
    $("#ds-add-save-btn").click(function () {
        $("#create-ds-form").submit(function () {
            //addDataSource();
            alert("asdfasdafadsf");
        });
    });

    // $("#create-ds-form").submit(function () {
    //     alert("asdfasdafadsf");
    // });


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
    let transports = root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value;
    let transportValues;

    if (transports) {
        transportValues = transports.split(" ");
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

/**
 * Populates Data sources data.
 *
 * @param root Document object.
 */
function populateDataSources(root) {
    let dsConfigs = root.getElementsByTagName("config");

    if (!dsConfigs) {
        return;
    }

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        let dsName = dsConfigs[i].id;
        let markup = "<tr><td>" + dsName + "</td><td class='text-center'>" +
            "<i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";

        $("#ds-datasources-table tbody").append(markup);
    }

}

/**
 * Processes the add data source view.
 *
 * @param root Document object
 */
function addDataSource(root) {

    var validator = $("#create-ds-form").data("bs.validator");
    validator.validate();

    if (!validator.hasErrors()) {
        alert("askjhasdkfj");
    } else {

    }

    // let formData = $("#create-ds-form").find(':visible').serializeArray();
    // let rdbmsType = $("#ds-dstype-select").val();
    //
    // if (rdbmsType == "rdbms_ds") {
    //
    // } else if (rdbmsType == "carbon_ds") {
    //
    // }

}

//------------ Utility functions ------------//
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