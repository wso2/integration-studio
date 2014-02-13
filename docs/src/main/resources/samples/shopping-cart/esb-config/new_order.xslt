<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:ord="http://shoppingcart.acme.com/order"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">
    <xsl:param name="CUSTOMER_EMAIL">220</xsl:param>


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">
        <ord:addNewOrder>
         <ord:orderDate>2010-10-10</ord:orderDate>
         <ord:requiredDate>2010-10-10</ord:requiredDate>
         <ord:shippedDate>2010-10-10</ord:shippedDate>
         <ord:status>OK</ord:status>
         <ord:comments>test</ord:comments>
         <ord:customerEmail>
             <xsl:value-of select="$CUSTOMER_EMAIL"></xsl:value-of>
         </ord:customerEmail>
      </ord:addNewOrder>
    </xsl:template>
</xsl:stylesheet>
