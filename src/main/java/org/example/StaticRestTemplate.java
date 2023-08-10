package org.example;

import org.springframework.web.client.RestTemplate;

public class StaticRestTemplate {

    public volatile static RestTemplate rest = new RestTemplate();
    public static volatile String jsessionid = "";
    // This way, I can test on local or server just  by changing one URL.
    public static volatile String baseURL = "http://94.198.50.185:7081/api/users";
}
