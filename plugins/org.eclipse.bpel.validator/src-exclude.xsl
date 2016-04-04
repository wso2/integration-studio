<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

 <xsl:template match="classpath">
   <project name="Remove sources not used in main compilation" default="moveUnused">
     <target name="moveUnused">
         <xsl:apply-templates />
     </target>
   </project>
 </xsl:template>
 
 <xsl:template match="classpathentry">
     <xsl:if test="@kind = 'src' and @path and @excluding">
         <echo><xsl:attribute name="message">Excluding "<xsl:value-of select="@excluding"/>" from "<xsl:value-of select="@path"/>"</xsl:attribute></echo>
         <move todir="src-excluded">
           <fileset>
               <xsl:attribute name="dir"><xsl:value-of select="@path"/></xsl:attribute>
               <include>
                   <xsl:attribute name="name"><xsl:value-of select="@excluding"/></xsl:attribute>
               </include>
           </fileset>
         </move>
     </xsl:if>  
 </xsl:template>
 </xsl:stylesheet>