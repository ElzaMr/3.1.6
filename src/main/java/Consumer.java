import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        /////////////Делаем запрос гет на сервер
        String url = "https://reqres.in/api/users/2";
        String method = "sdf";
        RestTemplate restTemplate = new RestTemplate();// с помощью этого класса делается запрос к серверу
        String response = restTemplate.getForObject(url, String.class);//получаем стрингу с данными
//        System.out.println(response);

//////////////////////////////делаем пост запрос на сервер
        String urlPost = "https://reqres.in/api/users";
        Map<String,String> jsonToSend = new HashMap<>();// создаем Мапу с полями для json
        jsonToSend.put("name","Test name");
        jsonToSend.put("job","TestJob");

        //оборачиваем мапу в класс-обертку
        HttpEntity<Map<String,String>> httpEntity = new HttpEntity<>(jsonToSend);

        //делаем запрос
        String responsePost = restTemplate.postForObject(urlPost,httpEntity, String.class);

        System.out.println(responsePost);
    }
}
