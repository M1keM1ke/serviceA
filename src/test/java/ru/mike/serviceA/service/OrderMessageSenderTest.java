package ru.mike.serviceA.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mike.serviceA.ServiceApplication;
import ru.mike.serviceA.config.RabbitConfig;
import ru.mike.serviceA.dto.MsgA;
import static org.mockito.ArgumentMatchers.eq;
import static org.assertj.core.api.Assertions.assertThatCode;

public class OrderMessageSenderTest {
    private ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);
    private RabbitTemplate rabbitTemplate = Mockito.mock(RabbitTemplate.class);

    @Test
    public void sendOrderTest() throws JsonProcessingException {
        MsgA msgA = new MessageGenerateService().generateMessage();

        Mockito.when(objectMapper.writeValueAsString(msgA)).thenReturn(Mockito.anyString());
        objectMapper.writeValueAsString(msgA);
        Mockito.verify(objectMapper).writeValueAsString(Mockito.any(MsgA.class));
    }
}
