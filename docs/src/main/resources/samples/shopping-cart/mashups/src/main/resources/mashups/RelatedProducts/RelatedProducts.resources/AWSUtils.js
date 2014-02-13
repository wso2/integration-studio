getSignedUrl.visible = false;
function getSignedUrl(unsignedUrl, keyId, secret) {

    var lines = unsignedUrl.split("\n");
    unsignedUrl = "";
    for (var i in lines) {
        unsignedUrl += lines[i];
    }

    // find host and query portions
    var urlregex = new RegExp("^http:\\/\\/(.*)\\/onca\\/xml\\?(.*)$");
    var matches = urlregex.exec(unsignedUrl);

    var host = matches[1].toLowerCase();
    var query = matches[2];

    // split the query into its constituent parts
    var pairs = query.split("&");

    // remove signature if already there
    // remove access key id if already present 
    //  and replace with the one user provided above
    // add timestamp if not already present
    pairs = cleanupRequest(pairs, keyId);

    // encode the name and value in each pair
    pairs = encodeNameValuePairs(pairs);

    // sort them and put them back together to get the canonical query string
    pairs.sort();

    var canonicalQuery = pairs.join("&");
    var stringToSign = "GET\n" + host + "\n/onca/xml\n" + canonicalQuery;

    // calculate the signature
    var signature = sign(secret, stringToSign);

    // assemble the signed url
    var signedUrl = "http://" + host + "/onca/xml?" + canonicalQuery + "&Signature=" + signature;

    return signedUrl;
}
encodeNameValuePairs.visible = false;
function encodeNameValuePairs(pairs) {
    for (var i = 0; i < pairs.length; i++) {
        var name = "";
        var value = "";

        var pair = pairs[i];
        var index = pair.indexOf("=");

        // take care of special cases like "&foo&", "&foo=&" and "&=foo&" 
        if (index == -1) {
            name = pair;
        } else if (index == 0) {
            value = pair;
        } else {
            name = pair.substring(0, index);
            if (index < pair.length - 1) {
                value = pair.substring(index + 1);
            }
        }

        // decode and encode to make sure we undo any incorrect encoding
        name = encodeURIComponent(decodeURIComponent(name));

        value = value.replace(/\+/g, "%20");
        value = encodeURIComponent(decodeURIComponent(value));
				value = value.replace(/\%3a/g, "%3A");
				value = value.replace(/\%2c/g, "%2C");

        pairs[i] = name + "=" + value;
    }

    return pairs;
}

cleanupRequest.visible = false;
function cleanupRequest(pairs, accessKeyId) {
    var haveTimestamp = false;
    var haveAwsId = false;

    var nPairs = pairs.length;
    var i = 0;
    while (i < nPairs) {
        var p = pairs[i];
        if (p.search(/^Timestamp=/) != -1) {
            haveTimestamp = true;
        } else if (p.search(/^(AWSAccessKeyId|SubscriptionId)=/) != -1) {
            pairs.splice(i, 1, "AWSAccessKeyId=" + accessKeyId);
            haveAwsId = true;
        } else if (p.search(/^Signature=/) != -1) {
            pairs.splice(i, 1);
            i--;
            nPairs--;
        }
        i++;
    }

    if (!haveTimestamp) {
        pairs.push("Timestamp=" + getNowTimeStamp());
    }

    if (!haveAwsId) {
        pairs.push("AWSAccessKeyId=" + accessKeyId);
    }
    return pairs;
}

sign.visible = false;
function sign(secret, message) {
    var messageBytes = str2binb(message);
    var secretBytes = str2binb(secret);

    if (secretBytes.length > 16) {
        secretBytes = core_sha256(secretBytes, secret.length * chrsz);
    }

    var ipad = Array(16), opad = Array(16);
    for (var i = 0; i < 16; i++) {
        ipad[i] = secretBytes[i] ^ 0x36363636;
        opad[i] = secretBytes[i] ^ 0x5C5C5C5C;
    }

    var imsg = ipad.concat(messageBytes);
    var ihash = core_sha256(imsg, 512 + message.length * chrsz);
    var omsg = opad.concat(ihash);
    var ohash = core_sha256(omsg, 512 + 256);

    var b64hash = binb2b64(ohash);
    var urlhash = encodeURIComponent(b64hash);

    return urlhash;
}

Date.prototype.toISODate =
        new Function("with (this)\n    return " +
                "getFullYear()+'-'+addZero(getMonth()+1)+'-'" +
                "+addZero(getDate())+'T'+addZero(getHours())+':'" +
                "+addZero(getMinutes())+':'+addZero(getSeconds())+'.000Z'");

addZero.visible = false;
function addZero(n) {
    return ( n < 0 || n > 9 ? "" : "0" ) + n;
}

getNowTimeStamp.visible = false;
function getNowTimeStamp() {
    var time = new Date();
    var gmtTime = new Date(time.getTime() + (time.getTimezoneOffset() * 60000));
    return gmtTime.toISODate();
}
