package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Objects;

import static org.example.StaticRestTemplate.rest;


@SpringBootApplication
public class KataLastProject {
    //    public volatile static RestTemplate rest = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(KataLastProject.class);
    public static String url = "http://94.198.50.185:7081/api/users";

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(KataLastProject.class, args);
    }

    @Bean
    public String head() throws Exception {

        ResponseEntity<User[]> response = rest.getForEntity(
                url, User[].class);
        response.getHeaders();
        List<String> header = Objects.requireNonNull(response.getHeaders().get("Set-Cookie")).stream().toList();
        System.out.println(header.get(0));
        return header.get(0);
    }

    @Bean
    public void run() throws Exception {
        System.out.println(head());
    }

}

//////////////////////////////////////////////////////////////////////////POST
//        // Создаем заголовки запроса
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON); //Content-Type:"application/json"
//        headers.set("Cookie", getHeader());
//
//        // Создаем объект HttpEntity с параметрами и заголовками
//        String body = "{\"id\":3,\"name\":\"James\",\"lastName\":\"Brown\",\"age\":30}";
//        HttpEntity<String> entity = new HttpEntity<String>(body, headers);//создали сущность с боди
//
//        // Выполняем POST запрос
//        ResponseEntity<String> response2 = rest.exchange(url, HttpMethod.POST, entity, String.class);
//
//        // Получаем код ответа и тело ответа
//        int statusCode = response2.getStatusCodeValue();
//        String responseBody = response2.getBody();
//
//        // Выводим результат
//        System.out.println("Статус код: " + statusCode);
//        System.out.println("Тело ответа: " + responseBody);
//        //////////////////////////////////////////////////////////////////////////////////////////////PUT
////        HttpHeaders headers2 = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON); //Content-Type:"application/json"
////        headers.set("Cookie", getHeader());
//
//        // Создаем объект HttpEntity с параметрами и заголовками
//        String body3 = "{\"id\":3,\"name\":\"Thomas\",\"lastName\":\"Shelby\",\"age\":30}";
//        HttpEntity<String> entityPut = new HttpEntity<String>(body3, headers);//создали сущность с боди
//
//        // Выполняем PUT запрос
//        ResponseEntity<String> response3 = rest.exchange(url, HttpMethod.PUT, entityPut, String.class);
//
//        // Получаем код ответа и тело ответа
//        int statusCode3 = response3.getStatusCodeValue();
//        String responseBody3 = response3.getBody();
//
//        // Выводим результат
//        System.out.println("Статус код: " + statusCode3);
//        System.out.println("Тело ответа: " + responseBody3);
//        //////////////////////////////////////////////////////////////////////////////////////////////Delete
////        HttpHeaders headers3 = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON); //Content-Type:"application/json"
////        headers.set("Cookie", getHeader());
//        String id = "/3";
//
//        // Send the DELETE request and get the response
//        HttpEntity<String> entityDelete = new HttpEntity<String>(headers);//создали сущность с боди
//        ResponseEntity<String> response4 = rest.exchange(url+id, HttpMethod.DELETE, entityDelete, String.class);
//
//       // Получаем код ответа и тело ответа
//        int statusCode4 = response4.getStatusCodeValue();
//        String responseBody4 = response4.getBody();
//
//        // Выводим результат
//        System.out.println("Статус код: " + statusCode4);
//        System.out.println("Тело ответа: " + responseBody4);
//
//        StringBuilder code = new StringBuilder();
//        code.append(responseBody);
//        code.append(responseBody3);
//        code.append(responseBody4);
//        System.out.println(code);
//    }
//    public static String  getHeader(){
//        HttpHeaders httpHeaders = rest.headForHeaders(url);
//        List<String> list = httpHeaders.get("Set-Cookie");
//        assert list != null;
//        return list.get(0);
//    }
//
//}




