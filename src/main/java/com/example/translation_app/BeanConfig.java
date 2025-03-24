package com.example.translation_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClient;

@Configuration
public class BeanConfig {

    //@Bean
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
     @Bean
    public RestClient Restclient() {
      return  RestClient.builder().baseUrl("").build();
    }



}
