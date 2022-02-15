package org.iesfm.airline;

import org.iesfm.airline.api.controllers.FlightController;
import org.iesfm.airline.repository.FlightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class ApiConfiguration {

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() {
        Jackson2ObjectMapperBuilder oMapper = new Jackson2ObjectMapperBuilder();
        oMapper.failOnUnknownProperties(true);
        return oMapper;
    }
}
