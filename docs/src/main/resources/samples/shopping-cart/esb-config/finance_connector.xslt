<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:con="http://connectors.shoppingcart.acme.com"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">

    <xsl:param name="TOTAL_AMOUNT">220</xsl:param>


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">
        <con:notifyPurchase>
            <con:amount>
                <xsl:value-of select="$TOTAL_AMOUNT"></xsl:value-of>
            </con:amount>
        </con:notifyPurchase>

    </xsl:template>
</xsl:stylesheet>


