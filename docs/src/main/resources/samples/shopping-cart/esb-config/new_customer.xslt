<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:com="com.acme.shoppingcart"
                xmlns:pur="http://shoppingcart.acme.com/purchase"
                xmlns:xsd="http://purchasingservicedummy.shoppingcart.acme.com/xsd"
                exclude-result-prefixes="fn pur">
    <xsl:param name="CUSTOMER_EMAIL">220</xsl:param>


    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates select="//pur:checkout"/>
    </xsl:template>

    <xsl:template match="pur:checkout">
        <com:addNewCustomer>
           <com:customerEmail>
               <xsl:value-of select="$CUSTOMER_EMAIL"></xsl:value-of>
           </com:customerEmail>
           <com:customerName>dsf</com:customerName>
           <com:phone>343</com:phone>
           <com:addressLine1>s</com:addressLine1>
           <com:addressLine2>s</com:addressLine2>
           <com:city>s</com:city>
           <com:state>s</com:state>
           <com:postalCode>s</com:postalCode>
           <com:country>s</com:country>
        </com:addNewCustomer>


    </xsl:template>
</xsl:stylesheet>
