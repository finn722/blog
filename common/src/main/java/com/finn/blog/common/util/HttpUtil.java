package com.finn.blog.common.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.Duration;


public class HttpUtil<T> {


   private final RestTemplate restTemplate;

   public HttpUtil(RestTemplateBuilder restTemplateBuilder){
       this.restTemplate = restTemplateBuilder
               .setConnectTimeout(Duration.ofMillis(5000))
               .setReadTimeout(Duration.ofMillis(5000))
               .build();
   }

   public T get(String url,Class<T> responseType){
       return restTemplate.getForObject(url,responseType);
   }

    public T post(String url,Object request,Class<T> responseType){
         return restTemplate.postForObject(url,request,responseType);
    }


}
