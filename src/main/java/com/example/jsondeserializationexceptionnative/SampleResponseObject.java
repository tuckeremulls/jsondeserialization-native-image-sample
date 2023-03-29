package com.example.jsondeserializationexceptionnative;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SampleResponseObject {

    private String message;
    @JsonDeserialize(using = CustomDeserializer.class)
    private LocalDate date;

}
