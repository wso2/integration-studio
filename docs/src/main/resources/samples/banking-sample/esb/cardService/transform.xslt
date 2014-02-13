<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
                xmlns:m0="http://sample.wso2.org"
                exclude-result-prefixes="fn">
    <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/">

        <m0:issueCard>
		<m0:cID><xsl:value-of select="//m0:issueCard/m0:customerID"/></m0:cID>
		<m0:customerExists><xsl:value-of select="//m0:issueCard/m0:isExistingCustomer"/></m0:customerExists>
		<m0:cName><xsl:value-of select="//m0:issueCard/m0:customerName"/></m0:cName>
		<m0:accntNo><xsl:value-of select="//m0:issueCard/m0:accountNo"/></m0:accntNo>
	</m0:issueCard>

    </xsl:template>
</xsl:stylesheet>
