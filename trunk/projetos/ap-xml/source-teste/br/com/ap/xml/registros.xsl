<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<table border="2" bgcolor="yellow">
					<tr>
						<th>Nome</th>
						<th>Endereço</th>
						<th>Nascimento</th>
					</tr>
					<xsl:for-each select="registros/registro">
						<tr>
							<td>
								<xsl:value-of select="nome" />
							</td>
							<td>
								<xsl:value-of select="endereco" />
							</td>
							<td>
								<xsl:value-of select="nascimento" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>