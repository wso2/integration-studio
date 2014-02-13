/*
* Copyright 2010 WSO2, Inc. http://www.wso2.org
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
* Created 2010 Ruchira Wageesha; ruchira@wso2.com
*
*/

/**
 * This mashup expose a findRelatedItems web service in order to find related 
 * products for a particular keyword from major online sellers such as ebay, 
 * amazon etc.
 */

system.include("sha2.js");
system.include("AWSUtils.js");

this.serviceName="RelatedProducts";
this.serviceParameters={"wsDiscoveryParams" : <><Scopes>http://shopping-cart.samples.stratos.wso2.org/service/relatedproducts</Scopes></>};

var products;
var errors;
var ebayNS = "urn:ebay:apis:eBLBaseComponents";
var amazonNS = "http://webservices.amazon.com/AWSECommerceService/2010-06-01";
var ebayAppID = "WSO214d6b-846d-41c3-aafc-0f5b02ec20c";
var amazonKeyID = "AKIAJQTQ6SRATRIVDZQA";
var amazonKey = "aXKmOphv+zxjy7FiOZQG5bXLraLlTfwCLFCtGUV7";

var waitingEbay;
var waitingAmazon;

var errorEbay=false;
var errorAmazon=false;

getRelatedProducts.inputTypes = {"query" : "string", "count" : "1|2|3|4|5|6|7|8|9|10", "format" : "xml|json"};
getRelatedProducts.outputType = "any";
function getRelatedProducts(query, count, format) {
	var async = false;
	var msg;
	var amazonCount = Math.floor(count/2);
	var ebayCount = count - amazonCount;
	//we put the wait param into the session
	//this param is used to check whether all service invocations have taken place
	var timeout = 1000 * 20;
	if(format == "xml") {
		products = <RelatedItems/>;
		errors = <Errors/>;
	} else {
		products = {};
		errors = {};
	}
	
	if(ebayCount > 0) {
		waitingEbay = true;
		var ebayClient = new WSRequest();
		if(async) {
			ebayClient.onreadystatechange = function() {
				if(format == "xml") {
					ebayResponseXML(ebayClient, async, ebayCount);
				} else {
					ebayResponseJSON(ebayClient, async, ebayCount);
				}
			};
		}

		try {
			var ebayUrl = "http://open.api.ebay.com/shopping?version=685&appid=" + 
					ebayAppID + "&callname=FindPopularItems&QueryKeywords=" + encodeURIComponent(query);
			ebayClient.open("GET", ebayUrl, async);
			ebayClient.send(null);
			if(!async) {
				if(format == "xml") {
					ebayResponseXML(ebayClient, async, ebayCount);
				} else {
					ebayResponseJSON(ebayClient, async, ebayCount);
				}
			}
		} catch (e) {
			msg = "Error invoking eBay shopping service";
			waitingEbay = false;
			errorEbay = true;
			errors.ebay = msg;
			system.log(e.toString(),"error");
			system.log(msg);
		}
	}

	if(amazonCount > 0) {
		waitingAmazon = true;
		var amazonClient = new WSRequest();	
		var amazonUrl = getSignedUrl("http://ecs.amazonaws.com/onca/xml?Service=AWSECommerceService&" + 
				"Version=2010-06-01&Operation=ItemSearch&SearchIndex=All&ResponseGroup=Accessories&Keywords=" + query, amazonKeyID, amazonKey);
		try {
			amazonClient.open("GET", amazonUrl, false);
			amazonClient.send(null);
			var itemIds = "";
			for each(var item in amazonClient.responseE4X..amazonNS::Item) {
				itemIds = itemIds != "" ? itemIds + "," : itemIds;
				itemIds +=item.amazonNS::ASIN.toString();
			}
			//itemIds = "B001SER47Y,B002LITT3I,B0035FZJHQ,B001XURPQS,B0012YA85A,B001SER48I,B0035FZJM6,B0035FZJJ4,B0035FZJKS,B002LITT3S";
			//amazonClient = new WSRequest();
			if(async) {
				amazonClient.onreadystatechange = function() {
					if(format == "xml") {
						amazonResponseXML(amazonClient, async, amazonCount);
					} else {
						amazonResponseJSON(amazonClient, async, amazonCount);
					}
				};
			}
			amazonUrl = getSignedUrl("http://ecs.amazonaws.com/onca/xml?Service=AWSECommerceService&" + 
					"Version=2010-06-01&Operation=ItemLookup&ResponseGroup=ItemAttributes,Images,OfferSummary&" + 
					"ItemId=" + itemIds, amazonKeyID, amazonKey);
			amazonClient.open("GET", amazonUrl, async);
			amazonClient.send(null);
			if(!async) {
				if(format == "xml") {
					amazonResponseXML(amazonClient, async, amazonCount);
				} else {
					amazonResponseJSON(amazonClient, async, amazonCount);
				}
			}

		} catch (e) {
			msg = "Error invoking Amazon shopping service";
			waitingAmazon = false;
			errorAmazon = true;
			errors.amazon = msg;	
			system.log(e.toString(),"error");
			system.log(msg);
		}
	}

	//we are waiting util all services are invoked
	var wait = true;
	var time = 0;
	var delta = 100;
	while(wait && time < timeout) {
		system.wait(delta);
		time += delta;
		wait = false;
		if(waitingEbay) {
			print("watingEbay...");
			wait = true;
		} else if(waitingAmazon) {
			print("watingAmazone...");
			wait = true;
		}
	}
	if(!errorEbay || !errorAmazon) {
		return products;
	} else {
		//an error has occured invoking all services, so we gonna send an error notification
		if(format == "xml") {
			return <Errors><Messages>{errors}</Messages></Errors>;
		} else {
			return {errors : true, messages : errors};
		}
	}
}

ebayResponseXML.visible=false;   
function ebayResponseXML(response, async, count){
	if(response.readyState == 4) {
		waitingEbay = false;
		var msg;
		if(!response.error) {
			var error = response.responseE4X.ebayNS::Errors;
			if(error.length() == 0) {
				var items = <Partner id="ebay"></Partner>;
				var node = response.responseE4X..ebayNS::Item;
				for(var i=0;(i<node.length()&&i<count);i++) {
					var item = node[i];
					var child = <Item/>;
					child.Title = item.ebayNS::["Title"].toString();
					child.Url = item.ebayNS::["ViewItemURLForNaturalSearch"].toString();
					child.Img = item.ebayNS::["GalleryURL"].toString();
					child.Price = item.ebayNS::["ConvertedCurrentPrice"].toString();
					child.Currency = item.ebayNS::["ConvertedCurrentPrice"].@currencyID.toString();
					items.appendChild(child);
				}
				products.appendChild(items);
				system.log("eBay Web Service successfully invoked.");
			} else {
				msg = error.ebayNS::["LongMessage"].toString();
				errorEbay = true;
				errors.ebay = msg;
				system.log(msg);
			}
		} else {
			msg = "Error invoking eBay shopping service" + response.error;
			errorEbay = true;
			errors.ebay = msg;
			system.log(msg);
		}
	}
}

amazonResponseXML.visible=false;   
function amazonResponseXML(response, async, count){
	if(response.readyState == 4) {
		waitingAmazon = false;
		var msg;
		if(!response.error) {
			var error = response.responseE4X..amazonNS::Errors;
			if(error.length() == 0) {
				var items = <Partner id="amazon"></Partner>;
				var node = response.responseE4X..amazonNS::Item;
				for(var i=0;(i<node.length()&&i<count);i++) {
					var item = node[i];
					var child = <Item/>;
					child.Title = item.amazonNS::["ItemAttributes"].amazonNS::["Title"].toString();
					child.Url = item.amazonNS::["DetailPageURL"].toString();
					child.Img = item.amazonNS::["SmallImage"].amazonNS::["URL"].toString();
					//we need to add decimal point before last two digits
					var price = "";
					var currency = "";
					if(item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["CurrencyCode"].toString();
					} else if(item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["CurrencyCode"].toString();
					} else if(item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["CurrencyCode"].toString();
					}
			
					if(price != "" && currency != "") {
						if(!async) {
							price = price.substring(0, price.length-2) + "." + price.substring(price.length-2);
						}
						child.Price = price;
						child.Currency = currency;
					} /*else {
						child.price = "";
						child.currency = "";
					}*/
					items.appendChild(child);
				}
				products.appendChild(items);
				system.log("Amazon Web Service successfully invoked.");
			} else {
				msg = error..amazonNS::["Message"].toString();
				errorAmazon = true;
				errors.amazon = msg;
				system.log(msg);
			}
		} else {
			msg = "Error invoking Amazon shopping service" + response.error;
			errorAmazon = true;
			errors.amazon = msg;
			system.log(msg);
		}
	}	
}

ebayResponseJSON.visible=false;   
function ebayResponseJSON(response, async, count){
	if(response.readyState == 4) {
		waitingEbay = false;
		var msg;
		if(!response.error) {
			var error = response.responseE4X.ebayNS::Errors;
			if(error.length() == 0) {
				var items = {};
				var node = response.responseE4X..ebayNS::Item;
				for(var i=0;(i<node.length()&&i<count);i++) {
					var item = node[i];
					var child = {};
					var itemId = item.ebayNS::["ItemID"];
					child.title = item.ebayNS::["Title"].toString();
					child.url = item.ebayNS::["ViewItemURLForNaturalSearch"].toString();
					child.img = item.ebayNS::["GalleryURL"].toString();
					child.price = item.ebayNS::["ConvertedCurrentPrice"].toString();
					child.currency = item.ebayNS::["ConvertedCurrentPrice"].@currencyID.toString();
					items["ebay-" + itemId] = child;
				}
				products.ebay = items;
				system.log("eBay Web Service successfully invoked.");
			} else {
				msg = error.ebayNS::["LongMessage"].toString();
				errorEbay = true;
				errors.ebay = msg;
				system.log(msg);
			}
		} else {
			msg = "Error invoking eBay shopping service" + response.error;
			errorEbay = true;
			errors.ebay = msg;
			system.log(msg);
		}
	}
}

amazonResponseJSON.visible=false;   
function amazonResponseJSON(response, async, count){
	if(response.readyState == 4) {
		waitingAmazon = false;
		var msg;
		if(!response.error) {
			var error = response.responseE4X..amazonNS::Errors;
			if(error.length() == 0) {
				var items = {};
				var node = response.responseE4X..amazonNS::Item;
				for(var i=0;(i<node.length()&&i<count);i++) {
					var item = node[i];
					var child = {};
					var asin = item.amazonNS::["ASIN"];
					child.title = item.amazonNS::["ItemAttributes"].amazonNS::["Title"].toString();
					child.url = item.amazonNS::["DetailPageURL"].toString();
					child.img = item.amazonNS::["SmallImage"].amazonNS::["URL"].toString();
					//we need to add decimal point before last two digits
					var price = "";
					var currency = "";
					if(item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestNewPrice"].amazonNS::["CurrencyCode"].toString();
					} else if(item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestUsedPrice"].amazonNS::["CurrencyCode"].toString();
					} else if(item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["Amount"].toString() != "") {
						price = item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["Amount"].toString();
						currency = item.amazonNS::["OfferSummary"].amazonNS::["LowestRefurbishedPrice"].amazonNS::["CurrencyCode"].toString();
					}
			
					if(price != "" && currency != "") {
						if(!async) {
							price = price.substring(0, price.length-2) + "." + price.substring(price.length-2);
						}
						child.price = price;
						child.currency = currency;
					} /*else {
						child.price = "";
						child.currency = "";
					}*/
					items["amazon-" + asin] = child;
				}
				products.amazon = items;
				system.log("Amazon Web Service successfully invoked.");
			} else {
				msg = error..amazonNS::["Message"].toString();
				errorAmazon = true;
				errors.amazon = msg;
				system.log(msg);
			}
		} else {
			msg = "Error invoking Amazon shopping service" + response.error;
			errorAmazon = true;
			errors.amazon = msg;
			system.log(msg);
		}
	}	
}

            
