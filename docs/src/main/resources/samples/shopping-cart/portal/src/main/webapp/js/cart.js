/* -------------------------------------------------------------------   */
/* Simplyfy access for YUI Dom and Event Objects                         */
var yEvent = YAHOO.util.Event;
var yDom = YAHOO.util.Dom;

/* initate dom objects */
var oneDay = 1000 * 60 * 60 * 24;
var cookie_date = new Date();  // current date & time
cookie_date.setTime(cookie_date.getTime() + oneDay);


var cartData = yDom.get("cartData");
var catDiv = yDom.get("catagories_block");
/* page onload event handling */
yEvent.onDOMReady(
        function() {
            var cart_state = get_cookie("cart");
            if (trim(cart_state) == "show") {
                fillcart();
                yDom.get("cartData").style.display = "";
                yDom.addClass("showCartIcon", "selected");
            }
        }
        );

/*This method accept a block element as input and it toggle the display of it with an animation*/
function itemColapse(block) {
    var todoOther = "";
    var attributes = "";

    if (block.style.display == "none") {
        attributes = {
            opacity: { to: 1 }
        };
        var anim = new YAHOO.util.Anim(block, attributes);
        anim.animate();
        block.style.display = "";

        todoOther = "show";
        block.style.height = "auto";
    }
    else {
        attributes = {
            opacity: { to: 0 }
        };
        anim = new YAHOO.util.Anim(block, attributes);
        anim.duration = 0.3;
        anim.onComplete.subscribe(hideItem, block);

        anim.animate();

        todoOther = "hide";
        //parentNode.style.height = "50px";
    }

}


/*This method is an utility method for the above itmeColapse */
function hideItem(state, opts, item) {
    item.style.display = "none";
}

/* display or hide the cart (Triggered when clicking the cart button from the UI )  */
function toggleCart(linkObj) {
    fillcart();
    if (yDom.hasClass(linkObj, "selected")) {//hiding the cart
        yDom.removeClass(linkObj, "selected");
        set_cookie("cart", "hidden");
    } else { //showing the cart
        yDom.addClass(linkObj, "selected");
        set_cookie("cart", "show");
    }

    itemColapse(yDom.get("cartData"));
}


/* adds an item to the shopping cart*/
function addToCart(code, price, desc) {
    
    //Get the quantity for the code (if this product is added previously
    var q = get_cookie('q$#$' + code);
    if (q == null) {
        q = 0;
    } else {
        q = parseFloat(q);
    }
    q++;

    set_cookie("code$#$" + code, code);
    set_cookie('price$#$' + code, price);
    set_cookie('desc$#$' + code, desc);
    set_cookie('q$#$' + code, q);

    fillcart();
    //var showCartIcon = yDom.get("showCartIcon");
    if (!yDom.hasClass("showCartIcon", "selected")) {
        yDom.addClass("showCartIcon", "selected");
    }
    if (yDom.get("cartData").style.display == "none") {
        itemColapse(yDom.get("cartData"));
    }

    //highlight updated rows for sometime
    yEvent.onAvailable("domChecker", function() {
        hightlight_row("code$#$" + code, 3000);
    });
}

/*function addQuantity(code, count) {
 var sUrl = "quantity.jsp?itemId="+code+"&count="+count+"";
 fillcart(sUrl);
 }*/

/* Fill the cart with the cart data*/
function fillcart() {
    var cartString = "";
    var total = 0;
    var codeArray = new Array();
    codeArray = get_codes(); // this arrry will keep the item codes

    if (codeArray.length > 0) {
        cartString = '<h1>Your Cart</h1>';
        cartString += '<table class="item-list" cellpadding="0" cellspacing="0" border="0">' +
                      '<thead>' +
                      '<tr>' +
                      '<th>Item Description</th>' +
                      '<th>Quantity</th>' +
                      '<th class="lastColWidth pricecol">Price</th>' +
                      '<th class="lastColWidth pricecol">Ext Price</th>' +
                      '</tr>' +
                      '</thead>' +
                      '<tbody>';
        for (var i = 0; i < codeArray.length; i++) {
            var code = codeArray[i];
            var price = get_cookie("price$#$" + code);
            var desc = get_cookie("desc$#$" + code);
            var q = get_cookie("q$#$" + code);

            var item_total = parseFloat(price) * parseFloat(q);
            cartString += '<tr>' +
                          '<td>' + desc + '</td>' +
                          '<td><input class="qCol" id="code$#$' + code + '" type="text" value="' + q + '" /></td>' +
                          '<td class="pricecol">' + price + '</td>' +
                          '<td class="pricecol">' + item_total + '</td>' +
                          '</tr>';
            total += item_total;
        }

        cartString += "</tbody></table>";

        cartString += '<table cellpadding="0" cellspacing="0" style="width: 100%">' +
                      '<tr>' +
                      '<td><a class="clear_cart_btn" onclick="clear_cart()"></a></td>' +
                      '<td><a class="update_btn" onclick="handle_update()"></a></td>' +
                      '<td class="pricecol price-total">Sub total:' + total + '</td>' +
                      '</tr>' +
                      '</table>' +
                      '<div class="checkout-wrapper" id="cartCheckout"><a onclick="checkout()">' +
                      '<img src="images/checkout-big.gif" alt="Checkout" border="0" /></a></div>' +
                      '<div id="domChecker"></div>';//this div is just check the availability of dom
    } else {
        cartString += "<h1>Your Cart is empty.</h1>";
    }
    //set the total on checkout page
    yEvent.onAvailable("cartTotal", function() {
        yDom.get("cartTotal").innerHTML = total;
    });
    yDom.get("cartData").innerHTML = cartString;
    yEvent.onAvailable("cartCheckout", function() {
           if(yDom.get("cartTotal")){
                yDom.get("cartCheckout").style.display = "none";
           }
    });
}
function clear_cart(){
    var codeArray = new Array();
    codeArray = get_codes(); // this arrry will keep the item codes
    for (var i = 0; i < codeArray.length; i++) {
        var code = codeArray[i];
        delete_cookie("code$#$" + code);
        delete_cookie("price$#$" + code);
        delete_cookie("desc$#$" + code);
        delete_cookie("q$#$" + code);
    }
    fillcart();
    
}
function get_cart_total(){
    var total = 0;
    var codeArray = new Array();
    codeArray = get_codes(); // this arrry will keep the item codes
    for (var i = 0; i < codeArray.length; i++) {
        var code = codeArray[i];
        var price = get_cookie("price$#$" + code);
        var q = get_cookie("q$#$" + code);
        var item_total = parseFloat(price) * parseFloat(q);
        total += item_total;
    }
    return total;
}
function get_codes() {
    var a_all_cookies = document.cookie.split(';');
    var codeArray = new Array(); // this arrry will keep the item codes
    for (var i = 0; i < a_all_cookies.length; i++)
    {
        var cookie_part = a_all_cookies[i];
        var cookie_part_sliced = cookie_part.split("$#$");
        if (cookie_part_sliced.length > 0) {
            if (trim(cookie_part_sliced[0]) == "code") {
                var tmpCode = cookie_part_sliced[1].split("=")[0];
                codeArray.push(tmpCode);
            }
        }

    }
    return codeArray;
}
/*handle the update button click event */
/*This method take every item in the cart and update there quantities*/
function handle_update() {
    var rowsToHighLight = new Array();
    var quantityElems = yDom.getElementsByClassName("qCol", "input", "cartData");
    for (var i = 0; i < quantityElems.length; i++) {
        var code = quantityElems[i].id.split("$#$")[1];
        var q = quantityElems[i].value;
        var old_q = get_cookie("q$#$" + code);
        if (parseFloat(q) != parseFloat(old_q)) {//if something has changed
            rowsToHighLight.push(quantityElems[i].id); //push all the row ids having changed values to an array
            set_cookie("q$#$" + code, q); //set the new value
            if (q == 0) {
                delete_cookie("code$#$" + code);
                delete_cookie("price$#$" + code);
                delete_cookie("desc$#$" + code);
                delete_cookie("q$#$" + code);
            }
        }
    }
    yDom.get("cartData").innerHTML = "";
    //now has to update the chart in the ui
    fillcart();
    //highlight updated rows for sometime
    yEvent.onAvailable("domChecker", function() {
        for (var i = 0; i < rowsToHighLight.length; i++) {
            hightlight_row(rowsToHighLight[i], 3000);
        }
    });
}

/*Getting a cookie value from it's name*/
function get_cookie(check_name) {
    // first we'll split this cookie up into name/value pairs
    // note: document.cookie only returns name=value, not the other components
    var a_all_cookies = document.cookie.split(';');
    var a_temp_cookie = '';
    var cookie_name = '';
    var cookie_value = '';
    var b_cookie_found = false; // set boolean t/f default f

    for (i = 0; i < a_all_cookies.length; i++)
    {
        a_temp_cookie = a_all_cookies[i].split('=');
        cookie_name = a_temp_cookie[0].replace(/^\s+|\s+$/g, '');
        if (cookie_name == check_name)
        {
            b_cookie_found = true;
            if (a_temp_cookie.length > 1)
            {
                cookie_value = unescape(a_temp_cookie[1].replace(/^\s+|\s+$/g, ''));
            }
            return cookie_value;
            break;
        }
        a_temp_cookie = null;
        cookie_name = '';
    }
    if (!b_cookie_found)
    {
        return null;
    }
}
function checkout() {
    var parms = "";

    var codeArray = get_codes();    // get the codes from the cookie
    for (var i = 0; i < codeArray.length; i++) {
        var code = codeArray[i];
        var q = get_cookie("q$#$" + code);
        parms += code + ":" + q + ";";
    }
    var checkoutForm = document.getElementById("checkoutForm");
    document.getElementById("cart").value = parms;
    checkoutForm.submit();
}

function set_cookie(check_name, value) {
    document.cookie = check_name + "=" + value + ";path=/;expires=" + cookie_date.toGMTString();
}
function delete_cookie(check_name) {
    var now = new Date();
    now.setTime(now.getTime() - oneDay);
    document.cookie = check_name + "=;path=/;expires=" + now.toGMTString();
}

function trim(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g, "");
}
function hightlight_row(elmId, time) {
    yEvent.onAvailable(elmId, function() {
        var row = yDom.get(elmId).parentNode.parentNode;
        var rowChilds = row.childNodes;
        for (var i = 0; i < rowChilds.length; i++) {
            if (rowChilds[i].nodeName == "TD") {
                yDom.setStyle(row.childNodes[i], "background-color", "#e6edee");
            }
        }
        yDom.addClass(row, "highlighted");

        //hide loading div in some time
        setTimeout(function() {
            for (var i = 0; i < rowChilds.length; i++) {
                if (rowChilds[i].nodeName == "TD") {
                    yDom.setStyle(row.childNodes[i], "background-color", "#fff");
                }
            }
        }, time);
    });
}



