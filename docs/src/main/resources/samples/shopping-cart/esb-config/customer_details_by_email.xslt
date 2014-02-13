<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:cus="http://shoppingcart.acme.com/customer"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">
    <xsl:param name="CUSTOMER_EMAIL">220</xsl:param>


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">
        <cus:getCustomerByEmail>
           <cus:customerEmail>
               <xsl:value-of select="$CUSTOMER_EMAIL"></xsl:value-of>
           </cus:customerEmail>
        </cus:getCustomerByEmail>


    </xsl:template>
</xsl:stylesheet>
