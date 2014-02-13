
//  Example stubs for admin_RelatedProducts operations.  This function is not intended
//  to be called, but rather as a source for copy-and-paste development.

//  Note that this stub has been generated for use in DOM environments.


function stubs() {
        // getRelatedProducts operation
    try {
        /* anyType */ var getRelatedProductsReturn = admin_RelatedProducts.getRelatedProducts(/* string */ param_query, /* string */ param_count, /* string */ param_format);
    } catch (e) {
        // fault handling
    }

}
stubs.visible = false;

var admin_RelatedProducts = new WebService("SOAP12Endpoint");

admin_RelatedProducts.getRelatedProducts =
    function getRelatedProducts(/* string */ _query, /* string */ _count, /* string */ _format)
    {
        var isAsync, request, response, resultValue;
        this._options = new Array();
        isAsync = (this.getRelatedProducts.callback != null && typeof(this.getRelatedProducts.callback) == 'function');
        request = this.getRelatedProducts_payload(/* string */ _query, /* string */ _count, /* string */ _format);

        if (isAsync) {
            try {
                this._call(
                    "getRelatedProducts",
                    "http://www.w3.org/ns/wsdl/in-out",
                    request,
                    function(thisRequest, callbacks) {
                        if (thisRequest.error != null) {
                            callbacks[1](thisRequest.error);
                        } else {
                            response = thisRequest.responseXML;
                            if (response == null) {
                                resultValue = null;
                            } else {
                                resultValue = /* xs:anyType */ WebService.utils._convertJSType(response.documentElement.firstChild, true);
                            }
                            callbacks[0](resultValue);
                        }
                    },
                    new Array(this.getRelatedProducts.callback, this.getRelatedProducts.onError)
                );
            } catch (e) {
                var error;
                if (WebServiceError.prototype.isPrototypeOf(e)) {
                    error = e;
                } else if (e.name != null) {
                    // Mozilla
                    error = new WebServiceError(e.name, e.message + " (" + e.fileName + "#" + e.lineNumber + ")");
                } else if (e.description != null) {
                    // IE
                    error = new WebServiceError(e.description, e.number, e.number);
                } else {
                    error = new WebServiceError(e, "Internal Error");
                }
                this.getRelatedProducts.onError(error);
            }
        } else {
            try {
                                response = this._call("getRelatedProducts", "http://www.w3.org/ns/wsdl/in-out", request);
                                resultValue = /* xs:anyType */ WebService.utils._convertJSType(response.documentElement.firstChild, true);
                                return resultValue;
            } catch (e) {
                if (typeof(e) == "string") throw(e);
                if (e.message) throw(e.message);
                throw (e.reason);
            }
        }
        return null; // Suppress warnings when there is no return.
    }
admin_RelatedProducts.getRelatedProducts_payload =
    function (/* string */ _query, /* string */ _count, /* string */ _format) {
        
        return '<p:getRelatedProducts xmlns:p="http://services.mashup.wso2.org/RelatedProducts?xsd">' +
                (_query == null ? '' : '<query>' + this._encodeXML(_query) + '</query>') +
                (_count == null ? '' : '<count>' + this._encodeXML(_count) + '</count>') +
                (_format == null ? '' : '<format>' + this._encodeXML(_format) + '</format>') +
            '</p:getRelatedProducts>' ;
    }
admin_RelatedProducts.getRelatedProducts_payload.visible = false;
admin_RelatedProducts.getRelatedProducts.callback = null;



// WebService object.
function WebService(endpointName)
{
    this.readyState = 0;
    this.onreadystatechange = null;
    this.scriptInjectionCallback = null;
    this.proxyAddress = null;

    //public accessors for manually intervening in setting the address (e.g. supporting tcpmon)
    this.getAddress = function (endpointName)
    {
        return this._endpointDetails[endpointName].address;
    }

    this.setAddress = function (endpointName, address)
    {
        this._endpointDetails[endpointName].address = address;
    }

    // private helper functions
    this._getWSRequest = function()
    {
        var wsrequest;
        try {
            wsrequest = new WSRequest();
            // try to set the proxyAddress based on the context of the stub - browser or Mashup Server
            try {
                wsrequest.proxyEngagedCallback = this.scriptInjectionCallback;
                wsrequest.proxyAddress = this.proxyAddress;
            } catch (e) {
                try {
                    wsrequest.proxyEngagedCallback = this.scriptInjectionCallback;
                    wsrequest.proxyAddress = this.proxyAddress;
                } catch (e) { }
            }
        } catch(e) {
            try {
                wsrequest = new ActiveXObject("WSRequest");
            } catch(e) {
                try {
                    wsrequest = new SOAPHttpRequest();
                    
                } catch (e) {
                    throw new WebServiceError("WSRequest object not defined.", "WebService._getWSRequest() cannot instantiate WSRequest object.");
                }
            }
        }
        return wsrequest;
    }

    this._endpointDetails =
        {
            "SOAP12Endpoint": {
                "type" : "SOAP12",
                "address" : "http://123.231.40.74:9767/services/admin/RelatedProducts.SOAP12Endpoint/",
                "action" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "soapaction" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                }
            },
            "SecureSOAP12Endpoint": {
                "type" : "SOAP12",
                "address" : "https://123.231.40.74:9447/services/admin/RelatedProducts.SecureSOAP12Endpoint/",
                "action" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "soapaction" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                }
            },
            "SOAP11Endpoint": {
                "type" : "SOAP11",
                "address" : "http://123.231.40.74:9767/services/admin/RelatedProducts.SOAP11Endpoint/",
                "action" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "soapaction" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                }
            },
            "SecureSOAP11Endpoint": {
                "type" : "SOAP11",
                "address" : "https://123.231.40.74:9447/services/admin/RelatedProducts.SecureSOAP11Endpoint/",
                "action" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "soapaction" : {
                    "getRelatedProducts" : "http://services.mashup.wso2.org/RelatedProducts/ServiceInterface/getRelatedProductsRequest"
                },
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                }
            },
            "HTTPEndpoint": {
                "type" : "HTTP",
                "address" : "http://123.231.40.74:9767/services/admin/RelatedProducts.HTTPEndpoint/",
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                },
                "httpignoreUncited" : {
                        "getRelatedProducts" : "false"
                },
                "httpmethod" : {
                        "getRelatedProducts" : "POST"
                },
                "fitsInURLParams" : {
                        "getRelatedProducts" : true
                }
            },
            "SecureHTTPEndpoint": {
                "type" : "HTTP",
                "address" : "https://123.231.40.74:9447/services/admin/RelatedProducts.SecureHTTPEndpoint/",
                "httplocation" : {
                    "getRelatedProducts" : "getRelatedProducts"
                },
                "httpignoreUncited" : {
                        "getRelatedProducts" : "false"
                },
                "httpmethod" : {
                        "getRelatedProducts" : "POST"
                },
                "fitsInURLParams" : {
                        "getRelatedProducts" : true
                }
            }
    };
    this.endpoint = endpointName;

    this.username = null;
    this.password = null;

    this._encodeXML = function (value) {
        var str = value.toString();
        str = str.replace(/&/g, "&amp;");
        str = str.replace(/</g, "&lt;");
        return(str);
    };

    this._setOptions = function (details, opName) {
        var options = new Array();

        if (details.type == 'SOAP12') options.useSOAP = 1.2;
        else if (details.type == 'SOAP11') options.useSOAP = 1.1;
        else if (details.type == 'HTTP') options.useSOAP = false;

        if (options.useSOAP != false) {
            if (details.action != null) {
                options.useWSA = true;
                options.action = details.action[opName];
            } else if (details.soapaction != null) {
                options.useWSA = false;
                options.action = details.soapaction[opName];
            } else {
                options.useWSA = false;
                options.action = undefined;
            }
        }

        if (details["httpmethod"] != null) {
            options.HTTPMethod = details.httpmethod[opName];
        } else {
            options.HTTPMethod = null;
        }

        if (details["httpinputSerialization"] != null) {
            options.HTTPInputSerialization = details.httpinputSerialization[opName];
        } else {
            options.HTTPInputSerialization= null;
        }

        if (details["httplocation"] != null) {
            options.HTTPLocation = details.httplocation[opName];
        } else {
            options.HTTPLocation = null;
        }

        if (details["httpignoreUncited"] != null) {
            options.HTTPLocationIgnoreUncited = details.httpignoreUncited[opName];
        } else {
            options.HTTPLocationIgnoreUncited = null;
        }

        if (details["httpqueryParameterSeparator"] != null) {
            options.HTTPQueryParameterSeparator = details.httpqueryParameterSeparator[opName];
        } else {
            options.HTTPQueryParameterSeparator = null;
        }

        if (details["policies"]) {
            var policies = details["policies"][opName];
            for(i=0; i<policies.length; i++) {
                if(policies[i] == "UTOverTransport") {
                    options.useWSS = true;
                    break;
                }
            }
        }

        return options;
    };

    this._call = function (opName, pattern, reqContent, callback, userdata)
    {
        var details = this._endpointDetails[this.endpoint];
        this._options = this._setOptions(details, opName);

        var isAsync = (typeof(callback) == 'function');

        var thisRequest = this._getWSRequest();
        thisRequest.pattern = pattern;
        if (isAsync) {
            thisRequest._userdata = userdata;
            thisRequest.onreadystatechange =
                function() {
                    if (thisRequest.readyState == 4) {
                        callback(thisRequest, userdata);
                    }
                }
        }

        if (this.username == null)
            thisRequest.open(this._options, details.address, isAsync);
        else
            thisRequest.open(this._options, details.address, isAsync, this.username, this.password);

        thisRequest.send(reqContent);
        if (isAsync) {
            return "";
        } else {
            try {
                var resultContent = thisRequest.responseText;
                if (resultContent == "") {
                    throw new WebServiceError("No response", "WebService._call() did not recieve a response to a synchronous request.");
                }
                var resultXML = thisRequest.responseXML;
            } catch (e) {
                throw new WebServiceError(e);
            }
            return resultXML;
        }
    };
}
WebService.visible = false;

WebService.utils = {
    toXSdate : function (thisDate) {
        var year = thisDate.getUTCFullYear();
        var month = thisDate.getUTCMonth() + 1;
        var day = thisDate.getUTCDate();

        return year + "-" +
            (month < 10 ? "0" : "") + month + "-" +
            (day < 10 ? "0" : "") + day + "Z";
    },

    toXStime : function (thisDate) {
        var hours = thisDate.getUTCHours();
        var minutes = thisDate.getUTCMinutes();
        var seconds = thisDate.getUTCSeconds();
        var milliseconds = thisDate.getUTCMilliseconds();

        return (hours < 10 ? "0" : "") + hours + ":" +
            (minutes < 10 ? "0" : "") + minutes + ":" +
            (seconds < 10 ? "0" : "") + seconds +
            (milliseconds == 0 ? "" : (milliseconds/1000).toString().substring(1)) + "Z";
    },

    toXSdateTime : function (thisDate) {
        var year = thisDate.getUTCFullYear();
        var month = thisDate.getUTCMonth() + 1;
        var day = thisDate.getUTCDate();
        var hours = thisDate.getUTCHours();
        var minutes = thisDate.getUTCMinutes();
        var seconds = thisDate.getUTCSeconds();
        var milliseconds = thisDate.getUTCMilliseconds();

        return year + "-" +
            (month < 10 ? "0" : "") + month + "-" +
            (day < 10 ? "0" : "") + day + "T" +
            (hours < 10 ? "0" : "") + hours + ":" +
            (minutes < 10 ? "0" : "") + minutes + ":" +
            (seconds < 10 ? "0" : "") + seconds +
            (milliseconds == 0 ? "" : (milliseconds/1000).toString().substring(1)) + "Z";
    },

    parseXSdateTime : function (dateTime) {
        var buffer = dateTime.toString();
        var p = 0; // pointer to current parse location in buffer.

        var era, year, month, day, hour, minute, second, millisecond;

        // parse date, if there is one.
        if (buffer.substr(p,1) == '-')
        {
            era = -1;
            p++;
        } else {
            era = 1;
        }

        if (buffer.charAt(p+2) != ':')
        {
            year = era * buffer.substr(p,4);
            p += 5;
            month = buffer.substr(p,2);
            p += 3;
            day = buffer.substr(p,2);
            p += 3;
        } else {
            year = 1970;
            month = 1;
            day = 1;
        }

        // parse time, if there is one
        if (buffer.charAt(p) != '+' && buffer.charAt(p) != '-')
        {
            hour = buffer.substr(p,2);
            p += 3;
            minute = buffer.substr(p,2);
            p += 3;
            second = buffer.substr(p,2);
            p += 2;
            if (buffer.charAt(p) == '.')
            {
                millisecond = parseFloat(buffer.substring(p))*1000;
                // Note that JS fractional seconds are significant to 3 places - xs:time is significant to more -
                // though implementations are only required to carry 3 places.
                p++;
                while (buffer.charCodeAt(p) >= 48 && buffer.charCodeAt(p) <= 57) p++;
            } else {
                millisecond = 0;
            }
        } else {
            hour = 0;
            minute = 0;
            second = 0;
            millisecond = 0;
        }

        var tzhour = 0;
        var tzminute = 0;
        // parse time zone
        if (buffer.charAt(p) != 'Z' && buffer.charAt(p) != '') {
            var sign = (buffer.charAt(p) == '-' ? -1 : +1);
            p++;
            tzhour = sign * buffer.substr(p,2);
            p += 3;
            tzminute = sign * buffer.substr(p,2);
        }

        var thisDate = new Date();
        thisDate.setUTCFullYear(year);
        thisDate.setUTCMonth(month-1);
        thisDate.setUTCDate(day);
        thisDate.setUTCHours(hour);
        thisDate.setUTCMinutes(minute);
        thisDate.setUTCSeconds(second);
        thisDate.setUTCMilliseconds(millisecond);
        thisDate.setUTCHours(thisDate.getUTCHours() - tzhour);
        thisDate.setUTCMinutes(thisDate.getUTCMinutes() - tzminute);
        return thisDate;
    },

    _nextPrefixNumber : 0,

    _QNameNamespaceDecl : function (qn) {
        if (qn.uri == null) return "";
        var prefix = qn.localName.substring(0, qn.localName.indexOf(":"));
        if (prefix == "") {
            prefix = "n" + ++this._nextPrefixNumber;
        }
        return ' xmlns:' + prefix + '="' + qn.uri + '"';
    },

    _QNameValue : function(qn) {
        if (qn.uri == null) return qn.localName;
        var prefix, localName;
        if (qn.localName.indexOf(":") >= 0) {
            prefix = qn.localName.substring(0, qn.localName.indexOf(":"));
            localName = qn.localName.substring(qn.localName.indexOf(":")+1);
        } else {
            prefix = "n" + this._nextPrefixNumber;
            localName = qn.localName;
        }
        return prefix + ":" + localName;
    },

    scheme : function (url) {
        var s = url.substring(0, url.indexOf(':'));
        return s;
    },

    domain : function (url) {
        var d = url.substring(url.indexOf('://') + 3, url.indexOf('/',url.indexOf('://')+3));
        return d;
    },

    domainPort : function (url) {
        var d = this.domain(url);
        if (d.indexOf(":") >= 0)
        d = d.substring(d.indexOf(':') +1);
        return d;
    },

    domainNoPort : function (url) {
        var d = this.domain(url);
        if (d.indexOf(":") >= 0)
        d = d.substring(0, d.indexOf(':'));
        return d;
    },

    _serializeAnytype : function (name, value, namespace, optional) {
        // dynamically serialize an anyType value in xml, including setting xsi:type.
        if (optional && value == null) return "";
        var type = "xs:string";
        if (value == null) {
            value = "";
        } else if (typeof(value) == "number") {
            type = "xs:double";
        } else if (typeof(value) == "object" && value.nodeType != undefined) {
            type = "xs:anyType";
            value = WebService.utils._serializeXML(value);
        } else if (typeof(value) == "boolean") {
            type = "xs:boolean";
        } else if (typeof(value) == "object" && Date.prototype.isPrototypeOf(value)) {
            type = "xs:dateTime";
            value = WebService.utils.toXSdateTime(value);
        } else if (value.match(/^\s*true\s*$/g) != null) {
            type = "xs:boolean";
        } else if (value.match(/^\s*false\s*$/g) != null) {
            type = "xs:boolean";
        } else if (!isNaN(Date.parse(value))) {
            type = "xs:dateTime";
            value = WebService.utils.toXSdateTime(new Date(Date.parse(value)));
        } else if (value.match(/^\s*\-?\d*\-\d\d\-\d\dZ?\s*$/g) != null) {
            type = "xs:date";
        } else if (value.match(/^\s*\-?\d*\-\d\d\-\d\d[\+\-]\d\d:\d\d\s*$/g) != null) {
            type = "xs:date";
        } else if (value.match(/^\s*\d\d:\d\d:\d\d\.?\d*Z?\s*$/g) != null) {
            type = "xs:time";
        } else if (value.match(/^\s*\d\d:\d\d:\d\d\.?\d*[\+\-]\d\d:\d\d\s*$/g) != null) {
            type = "xs:time";
        } else if (value.match(/^\s*\-?\d*\-\d\d\-\d\dT\d\d:\d\d:\d\d\.?\d*Z?\s*$/g) != null) {
            type = "xs:dateTime";
        } else if (value.match(/^\s*\-?\d*\-\d\d\-\d\dT\d\d:\d\d:\d\d\.?\d*[\+\-]\d\d:\d\d\s*$/g) != null) {
            type = "xs:dateTime";
        } else if (value.match(/^\s*\d\d*\.?\d*\s*$/g) != null) {
            type = "xs:double";
        } else if (value.match(/^\s*\d*\.?\d\d*\s*$/g) != null) {
            type = "xs:double";
        } else if (value.match(/^\s*\</g) != null) {
    
            var browser = WSRequest.util._getBrowser();
            var parseTest;
            if (browser == "ie" || browser == "ie7") {
                parseTest = new ActiveXObject("Microsoft.XMLDOM");
                parseTest.loadXML(value);
                if (parseTest.parseError == 0)
                    type = "xs:anyType";
            } else {
                var parser = new DOMParser();
                parseTest = parser.parseFromString(value,"text/xml");
                if (parseTest.documentElement.nodeName != "parsererror" || parseTest.documentElement.namespaceURI != "http://www.mozilla.org/newlayout/xml/parsererror.xml")
                    type = "xs:anyType";
            }
        
        }
        if (type == "xs:string") {
            value = admin_RelatedProducts._encodeXML(value);
        }
        var starttag =   "<" + name +
                     (namespace == "" ? "" : " xmlns='" + namespace + "'") +
                     " xsi:type='" + type + "'" +
                     " xmlns:xs='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'" +
                     ">";
        var endtag = "</" + name + ">";
        return starttag + value + endtag;
    },

    _serializeXML : function(payload) {
        var browser = WSRequest.util._getBrowser();
        switch (browser) {
            case "gecko":
            case "safari":
                var serializer = new XMLSerializer();
                return serializer.serializeToString(payload);
                break;
            case "ie":
            case "ie7":
                return payload.xml;
                break;
            case "opera":
                var xmlSerializer = document.implementation.createLSSerializer();
                return xmlSerializer.writeToString(payload);
                break;
            case "undefined":
                throw new WebServiceError("Unknown browser", "WSRequest.util._serializeToString doesn't recognize the browser, to invoke browser-specific serialization code.");
        }
    },
    
    // library function for dynamically converting an element with js:type annotation to a Javascript type.
    _convertJSType : function (element, isWrapped) {
        if (element == null) return "";
        var extractedValue = WSRequest.util._stringValue(element);
        var resultValue, i;
        var type = element.getAttribute("js:type");
        if (type == null) {
            type = "#raw";
        } else {
            type = type.toString();
        }
        switch (type) {
            case "string":
                return extractedValue;
                break;
            case "number":
                return parseFloat(extractedValue);
                break;
            case "boolean":
                return extractedValue == "true" || extractedValue == "1";
                break;
            case "date":
                return WebService.utils.parseXSdateTime(extractedValue);
                break;
            case "array":
                resultValue = new Array();
                for (i=0; i<element.childNodes.length; i++) {
                    resultValue = resultValue.concat(WebService.utils._convertJSType(element.childNodes[i]));
                }
                return(resultValue);
                break;
            case "object":
                resultValue = new Object();
                for (i=0; i<element.childNodes.length; i++) {
                    resultValue[element.childNodes[i].tagName] = WebService.utils._convertJSType(element.childNodes[i]);
                }
                return(resultValue);
                break;
            case "xmlList":
                return element.childNodes;
                break;
            case "xml":
                return element.firstChild;
                break;
            case "#raw":
            default:
                if (isWrapped == true)
                    return element.firstChild;
                else return element;
                break;
        }
    }

};



    
    
    
    
    
        
        
        
        
        
            
            
            
                
                
                    
                    
                
                
                
                
                    
                
            
        
    


