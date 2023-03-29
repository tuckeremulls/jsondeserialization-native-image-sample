package com.example.jsondeserializationexceptionnative;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfiguration {

    @Bean
    SampleService webClient (WebClient.Builder webclientBuilder) {

        var webClient = webclientBuilder
                .baseUrl("http://localhost:8080/getsampledata")
                .build();

        var httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        return httpServiceProxyFactory.createClient(SampleService.class);
    }

}
