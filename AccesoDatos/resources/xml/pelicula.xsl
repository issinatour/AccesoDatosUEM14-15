<?xml version="1.0"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
<xsl:template match="/">

<html>
   <head>
      <title>
   	<xsl:value-of select="/pelicula/titulo"/>
      </title>	
   </head>	
   <body>
      <h1>
   	<xsl:value-of select="/pelicula/titulo"/>
      </h1>
      <b>Director:</b>	
      <xsl:value-of select="/pelicula/director"/>
      <br/>
      <b>Protagonista:</b>	
      <xsl:value-of select="/pelicula/actores/actor"/>
      <br/>		
   </body>	
</html> 
</xsl:template>	
</xsl:stylesheet>	