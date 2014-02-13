var defaultImg = "images/no-image.png";

$(document).ready(function() {

    var query = $('#product-title h1').text();

    function buildRelatedProductsHTML(response) {
        var code = "";
        var amazon = response.amazon;
        var ebay = response.ebay;
        code += ebay ?
                '<table cellpadding="0" cellspacing="0" border="0" class="product-table-tiled">' +
                '<th colspan="3">eBay</th><tr>' : "";
        for (var i in ebay) {
            var item = ebay[i];
            code += buildRelatedProductsCell(item);
        }
        code += ebay ? '</tr></table>' : "";

        code += amazon ?
                '<table cellpadding="0" cellspacing="0" border="0" class="product-table-tiled">' +
                '<th colspan="3">Amazon</th><tr>' : "";
        for (var i in amazon) {
            var item = amazon[i];
            code += buildRelatedProductsCell(item);
        }
        code += amazon ? '</tr></table>' : "";

        return code;
    }

    function buildRelatedProductsCell(item) {
        var img = item.img != "" ? item.img : defaultImg;
        var price = item.price && item.price != "" && item.currency && item.currency != "" ?
                    item.currency + item.price : "";
        var code = '<td><div class="related_item_box">' + '<a class="link-to-product" target="_blank" href="' + item.url + '">' +
                   '<img src="' + img + '" width="100" alt="">' + '</a>' + '<div>' +
                   item.title + '</div>' + '<table>' + '<tr>' + '<td class="price" align="left">' +
                   price + '</td>' + '<td align="right">' +
                   '<a class="add-to-cart" target="_blank" href="' + item.url + '">View</a>' +
                   '</div></td>' + '</tr>' + '</table>' + '</td>';
        return code;
    }

    function loadRelatedProducts(query) {
        admin_RelatedProducts.setAddress("SOAP12Endpoint", serviceEPR);
        admin_RelatedProducts.proxyAddress = '/carbon/admin/jsp/WSRequestXSSproxy_ajaxprocessor.jsp';
        admin_RelatedProducts.getRelatedProducts.onError = function(error) {
            $('#related-products').hide();
            $('#related-products-heading').hide();
        };
        admin_RelatedProducts.getRelatedProducts.callback = function (response) {
            if (!response.errors) {
                var code = buildRelatedProductsHTML(response);
                if (code != "") {
                    $('#related-products-heading').show();
                    $('#related-products').show('slow').html(code);
                } else {
                    $('#related-products-heading').hide();
                    $('#related-products').hide();
                }
            } else {
                $('#related-products-heading').hide();
                $('#related-products').hide();
            }
        }
        admin_RelatedProducts.getRelatedProducts(query, 6, "json");
    }

    loadRelatedProducts(query);
});
