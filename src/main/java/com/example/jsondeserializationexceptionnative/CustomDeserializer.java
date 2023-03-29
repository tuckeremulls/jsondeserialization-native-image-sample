package com.example.jsondeserializationexceptionnative;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomDeserializer extends StdDeserializer<LocalDate> {

    public CustomDeserializer() {

        super(CustomDeserializer.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        String dateString = jsonParser.getCodec().readValue(jsonParser, String.class);

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            return LocalDate.parse(dateString, formatter);

        } catch (DateTimeParseException e) {

            return null;
        }
    }

}
