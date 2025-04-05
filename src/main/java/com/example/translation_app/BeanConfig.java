package com.example.translation_app;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClient;

import java.time.Duration;

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
         return RestClient.builder().baseUrl("").build();
     }
         @Bean
         public RedisConnectionFactory redisConnectionFactory() {
             return new JedisConnectionFactory(); // or use LettuceConnectionFactory for newer versions
         }

         @Bean
         public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
             RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                     .entryTtl(Duration.ofHours(1)); // Set TTL for cache entries if needed

             return RedisCacheManager.builder(redisConnectionFactory)
                     .cacheDefaults(cacheConfig)
                     .build();
         }





}
