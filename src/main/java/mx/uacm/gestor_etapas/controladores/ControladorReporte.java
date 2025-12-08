package mx.uacm.gestor_etapas.controladores;

import net.sf.saxon.s9api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Controller
@RequestMapping("/reporte")
public class ControladorReporte {

    private RestTemplate restTemplate = new RestTemplate();
    // La URL de tu API
    private final String urlApiCronograma = "http://localhost:8080/api/recurso_cronograma";

    @GetMapping("/cronograma")
    public ResponseEntity<String> generarReporteCronograma() {
        try {
            // 1. Obtener el JSON crudo desde la API
            // Es importante pedirlo como String.class para que no lo intente deserializar Java
            String jsonResponse = restTemplate.getForObject(urlApiCronograma, String.class);

            if (jsonResponse == null) jsonResponse = "[]"; // Manejo básico de vacíos

            // 2. Configurar Saxon (Procesador XSLT 3.0)
            Processor processor = new Processor(false);
            XsltCompiler compiler = processor.newXsltCompiler();

            // Cargar el archivo XSLT desde resources
            InputStream xsltStream = new ClassPathResource("templates/xsl/reporte.xslt").getInputStream();
            XsltExecutable executable = compiler.compile(new StreamSource(xsltStream));

            // Cargar el transformador
            Xslt30Transformer transformer = executable.load30();

            // 3. Pasar el JSON como parámetro al XSLT
            // El nombre "jsonInput" debe coincidir con <xsl:param name="jsonInput"/> en el .xslt
            QName paramName = new QName("jsonInput");
            XdmAtomicValue jsonValue = new XdmAtomicValue(jsonResponse);
            java.util.Map<QName, XdmValue> parameters = new java.util.HashMap<>();
            parameters.put(paramName, jsonValue);

            transformer.setStylesheetParameters(parameters);

            // 4. Ejecutar la transformación y capturar la salida en un String
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Serializer out = processor.newSerializer(outputStream);
            out.setOutputProperty(Serializer.Property.METHOD, "html");
            out.setOutputProperty(Serializer.Property.INDENT, "yes");

            // Llamamos a callTemplate null (o el nombre de tu template inicial)
            // En XSLT 3.0 con json-to-xml, usualmente iniciamos invocando un template principal
            transformer.callTemplate(new QName("initial-template"), out);

            String htmlReporte = outputStream.toString("UTF-8");

            // 5. Retornar el HTML al navegador
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(htmlReporte);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("<h1>Error generando el reporte</h1><p>" + e.getMessage() + "</p>");
        }
    }
}