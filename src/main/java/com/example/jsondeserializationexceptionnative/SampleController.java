package com.example.jsondeserializationexceptionnative;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("sendwebclientrequest")
    SampleResponseObject sendWebClientRequest() {

        SampleResponseObject sampleResponseObject = sampleService.getSampleResponseObject();

        System.out.println("HELLO");

        return sampleResponseObject;
    }

    @GetMapping(value = "getsampledata", produces = MediaType.APPLICATION_JSON_VALUE)
    String getSampleResponse() {

        return """
                {
                	"message": "hello",
                	"date": "19990501"
                }
                """;
    }

}
