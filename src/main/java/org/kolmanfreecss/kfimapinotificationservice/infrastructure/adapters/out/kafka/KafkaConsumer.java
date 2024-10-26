package org.kolmanfreecss.kfimapinotificationservice.infrastructure.adapters.out.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kolmanfreecss.kfimapinotificationservice.domain.dto.IncidentDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumer
 * Used to consume messages from Kafka.
 * 
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaConsumer {
    
    public static final String INCIDENCE_TOPIC = "kf_imapi_incident_channel";
    
    public static final String GROUP_ID = "kf-imapi-notification-consumer";
    
    final ObjectMapper objectMapper;

    @KafkaListener(topics = INCIDENCE_TOPIC, groupId = GROUP_ID)
    public void incidenceEventConsumer(final String message) {
        try {
            log.info("KAFKACONSUMER -> Original message -> {}", message);
            final IncidentDto incidentDto = objectMapper.readValue(message, IncidentDto.class);
            log.info("KAFKACONSUMER -> Consumer consume Kafka message -> {}", incidentDto);
        } catch (Exception e) {
            log.error("Error while consuming the message", e);
        }
    }

}