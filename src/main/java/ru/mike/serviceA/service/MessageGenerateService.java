package ru.mike.serviceA.service;

import org.springframework.stereotype.Component;
import ru.mike.serviceA.dto.Coordinates;
import ru.mike.serviceA.dto.MsgA;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class MessageGenerateService {
    private String msg;
    private String lng;
    private Map<Integer, String> mapLang = new HashMap<>();

    {
        mapLang.put(0, "ru");
        mapLang.put(1, "en");
        mapLang.put(2, "es");
    }
    private Coordinates coordinates;

    public MessageGenerateService() {
    }

    public MsgA generateMessage() {
        msg = UUID.randomUUID().toString();
        lng = mapLang.get(ThreadLocalRandom.current().nextInt(0, 3));
        coordinates = new Coordinates(
                String.valueOf(ThreadLocalRandom.current().nextInt(-90, 91)),
                String.valueOf(ThreadLocalRandom.current().nextInt(0, 181))
        );

        return MsgA.builder()
                .msg(msg)
                .lng(lng)
                .coordinates(coordinates).build();
    }
}
