<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h1>Mi Biblioteca</h1>
				<table>
					<tr bgcolor="#885588">
						<th>Título</th>
						<th>Autor</th>
					</tr>				
					<xsl:for-each select="libreria/libro">
						<tr>
							<td>								
								<xsl:value-of select="titulo" />
							</td>
							<td>
								<xsl:value-of select="autor" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet> 


