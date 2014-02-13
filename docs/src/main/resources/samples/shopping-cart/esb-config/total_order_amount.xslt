<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:ord="http://shoppingcart.acme.com/order"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">

    <xsl:param name="ORDER_NUMBER">220</xsl:param>
    


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">

        <ord:getTotalOrderAmount>
           <ord:orderNumber>
               <xsl:value-of select="$ORDER_NUMBER"></xsl:value-of>
           </ord:orderNumber>
        </ord:getTotalOrderAmount>

    </xsl:template>
</xsl:stylesheet>
