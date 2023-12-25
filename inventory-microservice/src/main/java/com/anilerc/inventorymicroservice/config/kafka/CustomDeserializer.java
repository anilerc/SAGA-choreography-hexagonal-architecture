package com.anilerc.inventorymicroservice.config.kafka;

import com.anilerc.inventorymicroservice.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String s, byte[] bytes) {
        try {

            if (bytes == null) {
                return null;
            }

            return objectMapper.readValue((new String(bytes, "UTF-8")), SaleMessage.class);

        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to SaleMessage!");
        }
    }
}
