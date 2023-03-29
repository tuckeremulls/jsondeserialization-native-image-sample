package com.example.jsondeserializationexceptionnative;

import org.springframework.web.service.annotation.GetExchange;

public interface SampleService {

    @GetExchange
    SampleResponseObject getSampleResponseObject();

}
