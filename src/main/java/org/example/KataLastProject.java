package org.example;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class KataLastProject {
    public static OkHttpClient client = new OkHttpClient();
    public static volatile String jsessionid = "";
    public volatile static RestTemplate rest = new RestTemplate();
    public static String url = "http://94.198.50.185:7081/api/users";

    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response1 = restTemplate.getForEntity(url, String.class);
        //  System.out.println(response1);
        HttpHeaders httpHeaders = restTemplate.headForHeaders(url);
        List<String> list = httpHeaders.get("Set-Cookie");
        assert list != null;
        String header = list.get(0);
        System.out.println(header);
////////////////////////////////////////////////////////////////////////POST
        // Создаем заголовки запроса
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); //Content-Type:"application/json"
        headers.set("Cookie", header);

        // Создаем объект HttpEntity с параметрами и заголовками
        String body = "{\"id\":3,\"name\":\"James\",\"lastName\":\"Brown\",\"age\":30}";
        HttpEntity<String> entity = new HttpEntity<String>(body, headers);//создали сущность с боди

        // Выполняем POST запрос
        ResponseEntity<String> response2 = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // Получаем код ответа и тело ответа
        int statusCode = response2.getStatusCodeValue();
        String responseBody = response2.getBody();

        // Выводим результат
        System.out.println("Статус код: " + statusCode);
        System.out.println("Тело ответа: " + responseBody);
        //////////////////////////////////////////////////////////////////////////////////////////////PUT

        // Создаем объект HttpEntity с параметрами и заголовками
        String body3 = "{\"id\":3,\"name\":\"Thomas\",\"lastName\":\"Shelby\",\"age\":30}";
        HttpEntity<String> entityPut = new HttpEntity<String>(body3, headers);//создали сущность с боди

        // Выполняем PUT запрос
        ResponseEntity<String> response3 = restTemplate.exchange(url, HttpMethod.PUT, entityPut, String.class);

        // Получаем код ответа и тело ответа
        int statusCode3 = response3.getStatusCodeValue();
        String responseBody3 = response3.getBody();

        // Выводим результат
        System.out.println("Статус код: " + statusCode3);
        System.out.println("Тело ответа: " + responseBody3);
        //////////////////////////////////////////////////////////////////////////////////////////////PUT
        String id = "/3";

        // Send the DELETE request and get the response
        HttpEntity<String> entityDelete = new HttpEntity<String>(headers);//создали сущность с боди
        ResponseEntity<String> response4 = restTemplate.exchange(url+id, HttpMethod.DELETE, entityDelete, String.class);

       // Получаем код ответа и тело ответа
        int statusCode4 = response4.getStatusCodeValue();
        String responseBody4 = response4.getBody();

        // Выводим результат
        System.out.println("Статус код: " + statusCode4);
        System.out.println("Тело ответа: " + responseBody4);

        StringBuilder code = new StringBuilder();
        code.append(responseBody);
        code.append(responseBody3);
        code.append(responseBody4);
        System.out.println(code);
    }
}




