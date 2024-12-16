package com.example.packageTracker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PackageTrackingService {

    private static final String API_KEY = "tu-api-key-aqui"; // Reemplaza con tu API Key
    private static final String API_URL = "https://api.aftership.com/v4/trackings/";

    public String trackPackage(String trackingNumber) {
        String url = API_URL + trackingNumber;
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Configurar el encabezado con la API key
            HttpHeaders headers = new HttpHeaders();
            headers.set("aftership-api-key", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Realizar la solicitud GET a AfterShip
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            // Procesar la respuesta de la API (esto es un ejemplo simple)
            String responseBody = response.getBody();
            return responseBody;  // Deberías extraer el estado del paquete de la respuesta JSON
        } catch (Exception e) {
            return "Error al rastrear el paquete: " + e.getMessage();
        }
    }
}
