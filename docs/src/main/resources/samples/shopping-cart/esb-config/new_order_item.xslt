<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:com="com.acme.shoppingcart"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">

    <xsl:param name="ORDER_NUMBER">220</xsl:param>
    <xsl:param name="PROD_CODE_TMP">220</xsl:param>
    <xsl:param name="PROD_QTY_TMP">220</xsl:param>


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">

        <com:addNewOrderItem>
            <com:orderNumber>
                <xsl:value-of select="$ORDER_NUMBER"></xsl:value-of>
            </com:orderNumber>
            <com:productCode>
                <xsl:value-of select="$PROD_CODE_TMP"></xsl:value-of>
            </com:productCode>
            <com:quantityOrdered>
                <xsl:value-of select="$PROD_QTY_TMP"></xsl:value-of>
            </com:quantityOrdered>
        </com:addNewOrderItem>


    </xsl:template>
</xsl:stylesheet>
