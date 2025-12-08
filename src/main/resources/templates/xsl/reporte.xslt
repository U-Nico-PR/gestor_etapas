<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/xpath-functions"
                xmlns:math="http://www.w3.org/2005/xpath-functions/math"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="xs math fn"
                version="3.0">

    <xsl:output method="html" indent="yes" html-version="5.0"/>

    <xsl:param name="jsonInput"/>

    <xsl:template name="initial-template">
        <xsl:variable name="xml-data" select="json-to-xml($jsonInput)"/>

        <html>
            <head>
                <title>Reporte de Cronograma</title>
                <link rel="stylesheet" th:href="@{/css/estiloscrono.css}">
                <style>
                    body { font-family: 'Segoe UI', sans-serif; padding: 20px; background: #f9f9f9; }
                    .cronograma-container { background: white; padding: 20px; margin-bottom: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
                    h1 { color: #2c3e50; text-align: center; }
                    h2 { color: #e67e22; border-bottom: 2px solid #e67e22; padding-bottom: 5px; }
                    h3 { color: #3498db; margin-top: 15px; }
                    table { width: 100%; border-collapse: collapse; margin-top: 10px; }
                    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
                    th { background-color: #f2f2f2; color: #333; }
                    .badge { padding: 4px 8px; border-radius: 4px; font-size: 0.8em; font-weight: bold; }
                    .badge-pendiente { background: #ffeeba; color: #856404; }
                    .badge-finalizada { background: #d4edda; color: #155724; }
                </style>
            </head>
            <body>
                <h1>Reporte Ejecutivo de Cronogramas</h1>

                <xsl:for-each select="$xml-data/fn:array/fn:map">
                    <div class="cronograma-container">
                        <h2>Cronograma #<xsl:value-of select="fn:number(@key) + 1"/>: <xsl:value-of select="fn:string[@key='descripcion']"/></h2>
                        <p><strong>Periodo:</strong>
                            <xsl:value-of select="fn:string[@key='fecha_inicio']"/> al
                            <xsl:value-of select="fn:string[@key='fecha_final']"/>
                        </p>

                        <xsl:for-each select="fn:array[@key='etapas']/fn:map">
                            <div style="margin-left: 20px;">
                                <h3>Etapa: <xsl:value-of select="fn:string[@key='nombre']"/> (<xsl:value-of select="fn:string[@key='fase']"/>)</h3>
                                <p><em><xsl:value-of select="fn:string[@key='descripcion']"/></em></p>

                                <table>
                                    <thead>
                                        <tr>
                                            <th>Actividad</th>
                                            <th>Tipo</th>
                                            <th>Fechas</th>
                                            <th>Hrs Est.</th>
                                            <th>Hrs Reales</th>
                                            <th>Entregable</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <xsl:for-each select="fn:array[@key='actividades']/fn:map">
                                            <tr>
                                                <td><xsl:value-of select="fn:string[@key='nombre']"/></td>
                                                <td><xsl:value-of select="fn:string[@key='tipo']"/></td>
                                                <td>
                                                    <xsl:value-of select="fn:string[@key='fecha_inicio']"/> a
                                                    <xsl:value-of select="fn:string[@key='fecha_final']"/>
                                                </td>
                                                <td><xsl:value-of select="fn:number[@key='horas_estimadas']"/></td>
                                                <td><xsl:value-of select="fn:number[@key='horas_reales']"/></td>
                                                <td>
                                                    <xsl:choose>
                                                        <xsl:when test="fn:map[@key='entregable']">
                                                            <a href="{fn:map[@key='entregable']/fn:string[@key='url_repositorio']}" target="_blank">
                                                                <xsl:value-of select="fn:map[@key='entregable']/fn:string[@key='nombre']"/>
                                                            </a>
                                                        </xsl:when>
                                                        <xsl:otherwise>
                                                            <span style="color: #999;">- Sin Entregable -</span>
                                                        </xsl:otherwise>
                                                    </xsl:choose>
                                                </td>
                                            </tr>
                                        </xsl:for-each>
                                    </tbody>
                                </table>
                            </div>
                        </xsl:for-each>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>